package com.algore.application.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @PostMapping("/search")
    public ModelAndView searchRecipe(ModelAndView mv, String recipeName){

    }
}
