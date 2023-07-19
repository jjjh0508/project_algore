package com.algore.application.search.controller;


import com.algore.application.search.dto.SearchPagination;
import com.algore.application.search.dto.SearchDTO;
import com.algore.application.search.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class searchController {
    private final SearchService searchService;

    public searchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ModelAndView searchRecipe(ModelAndView mv, String recipeName, @RequestParam(defaultValue = "1") int page, HttpServletRequest request) {

        int totaListCnt = searchService.searchCnt(request.getParameter("recipeName"));
        SearchPagination pagination = new SearchPagination(totaListCnt, page);

        int startIndex = pagination.getStartIndex();
        int pageSiz = pagination.getPageSize();


        List<SearchDTO> mainViewDTOList = searchService.searchRecipe(request.getParameter("recipeName"), startIndex, pageSiz, page);


        mv.addObject("mainHomeList", mainViewDTOList);
        mv.addObject("recipeName",request.getParameter("recipeName"));
        System.out.println(recipeName);
        mv.addObject("pagination", pagination);
        mv.setViewName("/search");
        return mv;
    }

}
