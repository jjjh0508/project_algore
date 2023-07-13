package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.*;
import com.algore.application.recipe.service.RecipeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/view/{recipeNum}")
    public ModelAndView recipeDetailView(ModelAndView mv, @PathVariable("recipeNum") int recipeNum , Authentication authentication){
        
        RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipeNum);
        List<RecipeOrderDTO> recipeOrderList = recipeService.recipeOrder(recipeNum);
        List<RecipePhotoDTO> recipePhotoDTOList = recipeService.recipPhoto(recipeNum);
        List<CommentReadDTO> commentReadDTOList = recipeService.commentRead(recipeNum, authentication.getName());
        for (CommentReadDTO commentReadDTO: commentReadDTOList) {
            System.out.println(commentReadDTO);
        }
        mv.addObject("commentRead",commentReadDTOList);
        mv.addObject("recipPhoto",recipePhotoDTOList);
        mv.addObject("recipevlew",recipeviewDTO);
        mv.addObject("recipeOrderList",recipeOrderList);
        mv.setViewName("/recipe/view");
        return  mv;
    }



}
