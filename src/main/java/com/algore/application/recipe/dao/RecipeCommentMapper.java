package com.algore.application.recipe.dao;

import com.algore.application.recipe.dto.CommentInsertDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecipeCommentMapper {
    int registComment(CommentInsertDTO commentInsertDTO);
}
