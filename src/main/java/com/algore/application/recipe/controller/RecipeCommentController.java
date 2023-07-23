package com.algore.application.recipe.controller;

import com.algore.application.recipe.dto.CommentInsertDTO;
import com.algore.application.recipe.service.RecipeCommentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/comment")
public class RecipeCommentController {
    private final RecipeCommentService recipeCommentService;

    public RecipeCommentController(RecipeCommentService recipeCommentService) {
        this.recipeCommentService = recipeCommentService;
    }

    @PostMapping("/regist")
    public ModelAndView recipeComment(ModelAndView mv, CommentInsertDTO commentInsertDTO, RedirectAttributes rttr, Authentication authentication){

        int recipeNum = commentInsertDTO.getRecipeNum();


        if(authentication.getName()!=null){
            int result = recipeCommentService.registComment(commentInsertDTO);
            if(result>0){
                mv.setViewName("redirect:/recipe/view?recipe="+recipeNum);
                rttr.addFlashAttribute("message", "등록 성공했습니다..");
                return mv;
            }else {
                mv.setViewName("redirect:/recipe/view?recipe="+recipeNum);
                 rttr.addFlashAttribute("message", "등록 실패했습니다..");
                return mv;
            }

        }else {
            mv.setViewName("/common/login");
            mv.addObject("commentmessage", "로그인한 유저만 작성 가능합니다.");
            return mv;
        }


    }
}
