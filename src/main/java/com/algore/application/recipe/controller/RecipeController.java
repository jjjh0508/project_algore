package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.RecipeOrderDTO;
import com.algore.application.recipe.dto.RecipeviewDTO;
import com.algore.application.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/view/{recipeNum}")
    public ModelAndView recipeDetailView(ModelAndView mv, @PathVariable("recipeNum") int recipeNum){
        RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipeNum);
        List<RecipeOrderDTO> recipeOrderList = recipeService.recipeOrder(recipeNum);
        for (RecipeOrderDTO orderDTO : recipeOrderList){
            System.out.println(orderDTO+"확인");
        }
        mv.addObject("recipevlew",recipeviewDTO);
        mv.addObject("recipeOrderList",recipeOrderList);
        mv.setViewName("/recipe/view");
        return  mv;
    }


}
