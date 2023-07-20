package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.*;
import com.algore.application.recipe.service.RecipeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
        List<RecipePhotoDTO> recipePhotoDTOList = recipeviewDTO.getRecipePhotoDTOList();


        mv.setViewName("/recipe/view");
        return mv;
    }

    @GetMapping("/regist")
    public ModelAndView writeForm(ModelAndView mv, Authentication authentication, HttpServletRequest request, HttpServletResponse response) {

        List<RecipeCategoryDTO> recipeCategory = recipeService.readCategory();

        for (RecipeCategoryDTO Category: recipeCategory
             ) {
            System.out.println(Category);

        }
        mv.addObject("CategoryList", new RecipeCategoryDTO());
        mv.addObject("recipeCategory", recipeCategory);

        mv.setViewName("/recipe/write");
        return mv;
    }

    @PostMapping( "/registform")
    public ModelAndView writeReci(ModelAndView model, RecipeWriteDTO recipeWriteDTO) {

        int result = recipeService.writeRecipe(recipeWriteDTO);

        String path = "";
        if (result > 0) {
            model.addObject("message", "등록이 완료되었습니다.");
            model.setViewName("redirect:/view");
        } else {
            model.addObject("message", "등록에 실패하였습니다.");
            model.setViewName("redirect:/");
        }

        return model;
    }

    @GetMapping("/modify")
    public ModelAndView modifyForm(ModelAndView mv, Authentication authentication, @RequestParam("recipe") int recipe) {
        try {

            String name = recipeService.getUserName(recipe);

            System.out.println(authentication.getDetails());
            System.out.println(authentication.isAuthenticated());
            System.out.println(authentication.getPrincipal());
            System.out.println(authentication.getAuthorities());

            if (!authentication.getName().equals(name)) {
                //작성자만 수정가능
                mv.addObject("message", "작성자만 수정 가능합니다.");
                mv.setViewName("/common/error");
                return mv;
            }

            RecipeviewDTO recipeviewDTO = recipeService.DetailView(recipe);
            List<RecipePhotoDTO> recipePhotoDTOList = recipeviewDTO.getRecipePhotoDTOList();
            if(recipePhotoDTOList.isEmpty()){
                for(int i=0;i<4;i++){
                    recipePhotoDTOList.add(new RecipePhotoDTO());
                }
                recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
            }

            mv.addObject("recipevlew", recipeviewDTO);
            mv.setViewName("/recipe/modify");
        } catch (Exception e) {
            mv.addObject("message", e.getMessage());
            mv.setViewName("/common/error");
        }

        return mv;
    }

    @PostMapping("/modifyform")
    public ModelAndView modifyRecipe(ModelAndView mv, RecipeviewDTO recipeviewDTO, HttpServletRequest request) {
        int result = recipeService.modifyRecipe(recipeviewDTO);

        if (result > 0) {
            mv.setViewName("redirect:/recipe/view?recipe=" + recipeviewDTO.getRecipeNum());
        } else {
            mv.addObject("message", "수정 실패하였습니다.");
            mv.setViewName("/common/error");
        }

        return mv;
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
