package com.algore.application.recipe.dao;

import com.algore.application.recipe.dto.CommentReadDTO;
import com.algore.application.recipe.dto.RecipeOrderDTO;
import com.algore.application.recipe.dto.RecipePhotoDTO;
import com.algore.application.recipe.dto.RecipeviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeViewMapper {
    RecipeviewDTO DetailView(int recipeNum);

    List<RecipeOrderDTO> recipeOrder(int recipeNum);

    List<RecipePhotoDTO> recipPhoto(int recipeNum);

    List<CommentReadDTO> commentRead(int recipeNum);

    int viewCount(int recipeNum);

    String modifyName(int recipeNum);

    int recipeDelete(int recipe);
}
