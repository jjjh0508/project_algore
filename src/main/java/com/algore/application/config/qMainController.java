package com.algore.application.config;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Q&Aquestion")
public class qMainController{

    @GetMapping("/q&aMain")
    public void questionMain(){

    }

    @GetMapping("/q&a02")
    public void questionWrite(){

    }
    @GetMapping("/q&aModify")
    public void questionModify(){

    }

}