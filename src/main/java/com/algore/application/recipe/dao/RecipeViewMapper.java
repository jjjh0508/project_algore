package com.algore.application.recipe.dao;

import com.algore.application.recipe.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeViewMapper {
    RecipeviewDTO DetailView(int recipeNum);

    List<RecipeOrderDTO> recipeOrder(int recipeNum);

    List<RecipePhotoDTO> recipPhoto(int recipeNum);

    List<CommentReadDTO> commentRead(int recipeNum);

    int viewCount(int recipeNum);

    String getUserName(int recipeNum);

    int recipeDelete(int recipe);

    int modifyRecipe(RecipeviewDTO recipeviewDTO);

    int orderDelete(int recipeNum);

    int modifyOrder(List<ModifyRecipeOrder> modifyRecipeOrder);

    int modifyPhoto(List<RecipePhotoDTO> recipePhotoDTOList);

    int photoDelete(int recipeNum);

    int writeRecipe(RecipeWriteDTO recipeWriteDTO);
    List<RecipeCategoryDTO> readCategory();

<<<<<<< HEAD
//    int recipeProcedure(RecipeProcedureDTO recipeProcedureDTO);


=======
    List<RecipeIngredientDTO> recipeIngredient(int recipeNum);
>>>>>>> 202da24a6a1218bd898c7c8b5138a9a707efc29c
}
