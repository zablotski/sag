package info.zablotski.sag.six.controller;

/**
 * Created by zhenya on 11/4/15.
 */
import info.zablotski.sag.six.model.Foo;
import info.zablotski.sag.six.model.Names;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

@Controller
@RequestMapping(value = "/form")
public class HelloWorldController {


    @RequestMapping(method = RequestMethod.GET)
    public String formInput(Model model){
        model.addAttribute("firstName", "LOL");
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView formOutput(@RequestParam("first_name") String firstName, Model model, HttpServletRequest request,
                                   HttpServletResponse response, ModelAndView modelView){
        String errorMessage = null;
        modelView.setViewName("output");

        if (firstName.equals("Johny")) {
            response.setStatus(418);
        }

        if (firstName.equals("james") || firstName.equals("donna")) {
            try {
                Field field = Names.class.getDeclaredField(firstName);

                Foo annotation = field.getAnnotation(Foo.class);
                modelView.setViewName(annotation.value());

                try {

                    firstName = (String) FieldUtils.readField(new Names(), firstName, true);

                } catch (IllegalAccessException e) {
                    errorMessage = "Something went wrong. Please contact administrator. Error: " + e.getMessage();
                }
            } catch (NoSuchFieldException e) {
                errorMessage = "Something went wrong. Please contact administrator. Error: " + e.getMessage();
            }

        }
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("firstName", firstName);

        return  modelView;

    }

}
