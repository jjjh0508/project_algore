package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.*;
import com.algore.application.recipe.service.RecipeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/view")
    public ModelAndView recipeDetailView(ModelAndView mv, int recipe,
                                         Authentication authentication, HttpServletRequest request,
                                         HttpServletResponse response) {
        viewCount(request, response, recipe);
        RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipe);
        List<CommentReadDTO> commentReadDTOList = recipeService.commentRead(recipe);
        mv.addObject("commentRead", commentReadDTOList);
        mv.addObject("recipevlew", recipeviewDTO);


        mv.setViewName("/recipe/view");
        return mv;
    }

    @GetMapping("/modify")
    public ModelAndView modifyForm(ModelAndView mv, Authentication authentication, @RequestParam("recipe") int recipe) {
        try {
            String name = recipeService.getUserName(recipe);
            System.out.println(name + authentication.getName());
            if (!authentication.getName().equals(name)) {
                //작성자만 수정가능
                mv.addObject("message", "작성자만 수정 가능합니다.");
                mv.setViewName("/common/error");
                return mv;
            }
            RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipe);
            mv.addObject("recipevlew", recipeviewDTO);
            mv.setViewName("/recipe/modify");
        } catch (Exception e) {
            mv.addObject("message", e.getMessage());
            mv.setViewName("/common/error");
        }

        return mv;
    }

    @PostMapping("/modifyform")
    public String modifyRecipe(ModelAndView mv,  RecipeviewDTO recipeviewDTO, List<RecipeOrderDTO> recipeOrderList,List<RecipePhotoDTO> recipePhotoDTOList,HttpServletRequest request) {
        System.out.println(recipeviewDTO.getRecipeNum());
        System.out.println(recipeviewDTO.getRecipeTitle());
        System.out.println(recipeviewDTO.getCategory());
        for (RecipeOrderDTO orderDTO:recipeOrderList) {
            System.out.println(orderDTO);
        }

        System.out.println();


        return "왜 안돼";
    }







    @GetMapping("/delete")
    public ModelAndView recipeDelete(ModelAndView mv, Authentication authentication, @RequestParam("recipe") int recipe) {
        try {


            String name = recipeService.getUserName(recipe);
            if (!authentication.getName().equals(name)) {
                //작성자만 삭제가능
                mv.addObject("message", "작성자만 삭제 가능합니다.");
                mv.setViewName("/common/error");
                return mv;
            }
            int result = recipeService.recipeDelete(recipe);
            mv.setViewName("redirect:/home/?page=1");
            return mv;
        } catch (Exception e) {
            return mv;
        }
    }



    private void viewCount(HttpServletRequest request,
                           HttpServletResponse response, int recipeNum) {
        Cookie oldCookie = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("recipeView")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + recipeNum + "]")) {
                recipeService.viewCount(recipeNum);
                oldCookie.setValue(oldCookie.getValue() + "_[" + recipeNum + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            recipeService.viewCount(recipeNum);
            Cookie newCookie = new Cookie("recipeView", "[" + recipeNum + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }


}
