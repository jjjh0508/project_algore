package com.algore.application.home.controller;

import com.algore.application.home.dto.MainViewDTO;
import com.algore.application.home.service.HomeService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public ModelAndView mainHome(ModelAndView mv){
        List<MainViewDTO> mainViewDTOList = homeService.mainView();
        mv.addObject("mainHomeList",mainViewDTOList);
        mv.setViewName("/home");
        return mv;
    }



}
