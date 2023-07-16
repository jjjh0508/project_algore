package com.algore.application.search.controller;

import com.algore.application.search.dto.SearchDTO;
import com.algore.application.search.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class searchController {
    private final SearchService  searchService;

    public searchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ModelAndView searchRecipe(ModelAndView mv, String recipeName, HttpServletRequest request) {
        System.out.println(request.getParameter("recipeName"));
        List<SearchDTO> mainViewDTOList = searchService.searchRecipe(request.getParameter("recipeName"));

        for (SearchDTO asd: mainViewDTOList) {
            System.out.println(asd);
        }
        mv.addObject("mainHomeList",mainViewDTOList);


        mv.setViewName("/home");
        return mv;
    }

}
