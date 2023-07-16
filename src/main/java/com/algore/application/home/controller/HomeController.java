package com.algore.application.home.controller;

import com.algore.application.home.dto.MainViewDTO;
import com.algore.application.home.dto.Pagination;
import com.algore.application.home.service.HomeService;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public ModelAndView mainHome(ModelAndView mv,@RequestParam(defaultValue = "1") int page){


        int totaListCnt = homeService.allcnt();

        Pagination pagination = new Pagination(totaListCnt,page);

        int startIndex = pagination.getStartIndex();
        int pageSiz = pagination.getPageSize();



        List<MainViewDTO> mainViewDTOList = homeService.mainView(startIndex,pageSiz,page);


        mv.addObject("mainHomeList",mainViewDTOList);
        mv.addObject("pagination",pagination);
        mv.setViewName("/home");
        return mv;
    }



}
