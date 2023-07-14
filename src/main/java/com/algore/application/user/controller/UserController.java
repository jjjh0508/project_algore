package com.algore.application.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String main(){
        return "user/login";
    }

    @GetMapping("/idfind")
    public String idfind() {
        return "user/idfind";
    }

    @GetMapping("/idfindresult")
    public String idfindresult() {
        return "user/idfindresult";
    }

    @GetMapping("/passfind")
    public String passfind() { return "user/passfind"; }

    @GetMapping("/passsendcode")
    public String passsendcode() {
        return "user/passsendcode";
    }

    @GetMapping("/passinputcode")
    public String passinputcode() {
        return "user/passinputcode";
    }

    @GetMapping("/passreset")
    public String passreset() {
        return "user/passreset";
    }

    @GetMapping("join")
    public String join() {
        return "user/join";
    }

}
