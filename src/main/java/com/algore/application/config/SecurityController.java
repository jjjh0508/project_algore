package com.algore.application.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/common")
public class SecurityController {

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/test")
    public void index(){
    }

    @GetMapping("/loginfail")
    public ModelAndView loginFail(@RequestParam String errorMessage, ModelAndView mv){
        mv.addObject("errorMessage", errorMessage);
        mv.setViewName("common/loginFail");
        return mv;
    }

    @GetMapping("/layout")
    public ModelAndView model(ModelAndView mv){
        mv.setViewName("common/layouts/layout");
        return mv;
    }


}
