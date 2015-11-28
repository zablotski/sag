package info.zablotski.sag.nine.controller;

import info.zablotski.sag.nine.model.User;
import info.zablotski.sag.nine.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserDetailsServiceImpl udsi;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String formInput(){
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView formOutput(ModelAndView modelView, @RequestParam("userName") String userName, @RequestParam("password") String password){

        try{
            UserDetails repoUser = udsi.loadUserByUsername(userName);
            if (repoUser.getPassword().equals(password)){
                modelView.addObject("userInfo", repoUser.getUsername());
                modelView.setViewName("home");
            }
            else {
                throw new UsernameNotFoundException("");
            }
        }
        catch (UsernameNotFoundException e){
            modelView.addObject("error", "Invalid UserName / Password");
            modelView.setViewName("loginForm");
        }

        return  modelView;

    }

}
