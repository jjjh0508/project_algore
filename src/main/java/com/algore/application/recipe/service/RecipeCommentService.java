package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeCommentMapper;
import com.algore.application.recipe.dto.CommentInsertDTO;
import org.springframework.stereotype.Service;

@Service
public class RecipeCommentService {
   public final RecipeCommentMapper recipeCommentMapper ;

    public RecipeCommentService(RecipeCommentMapper recipeCommentMapper) {
        this.recipeCommentMapper = recipeCommentMapper;
    }

    public int registComment(CommentInsertDTO commentInsertDTO) {
        int result = recipeCommentMapper.registComment(commentInsertDTO);
        return result;
    }
}
