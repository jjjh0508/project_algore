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
import java.util.List;


@Controller
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/view/{recipeNum}")
    public ModelAndView recipeDetailView(ModelAndView mv, @PathVariable("recipeNum") int recipeNum,
                                         Authentication authentication, HttpServletRequest request,
                                         HttpServletResponse response) {
        viewCount(request, response, recipeNum);
        RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipeNum);
        List<RecipeOrderDTO> recipeOrderList = recipeService.recipeOrder(recipeNum);
        List<RecipePhotoDTO> recipePhotoDTOList = recipeService.recipPhoto(recipeNum);
        List<CommentReadDTO> commentReadDTOList = recipeService.commentRead(recipeNum, authentication.getName());

        mv.addObject("commentRead", commentReadDTOList);
        mv.addObject("recipPhoto", recipePhotoDTOList);
        mv.addObject("recipevlew", recipeviewDTO);
        mv.addObject("recipeOrderList", recipeOrderList);

        mv.setViewName("/recipe/view");
        return mv;
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
            Cookie newCookie = new Cookie("recipeView","[" + recipeNum + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }


}