package info.zablotski.sag.five.servlet;

import info.zablotski.sag.five.model.Foo;
import info.zablotski.sag.five.model.Names;
import org.apache.commons.lang.reflect.FieldUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/jsp/form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("first_name");
        if (firstName.equals("Johny")) {
            response.setStatus(418);
        }

        String returnPage = "output";

        if (firstName.equals("james") || firstName.equals("donna")) {
            try {
                Field field = Names.class.getDeclaredField(firstName);

                Foo annotation = field.getAnnotation(Foo.class);
                returnPage = annotation.value();

                try {

                    firstName = (String) FieldUtils.readField(new Names(), firstName, true);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        }

        request.setAttribute("first_name", firstName);

        request.getRequestDispatcher("/jsp/" + returnPage + ".jsp").forward(request, response);
    }
}