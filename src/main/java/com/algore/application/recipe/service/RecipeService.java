package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeViewMapper;
import com.algore.application.recipe.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    public final RecipeViewMapper mapper;

    public RecipeService(RecipeViewMapper mapper) {
        this.mapper = mapper;
    }

    public RecipeviewDTO DetailView(int recipeNum){
        RecipeviewDTO recipeviewDTO = mapper.DetailView(recipeNum);
        List<RecipeOrderDTO>recipeOrderDTOList = mapper.recipeOrder(recipeNum);
        List<RecipePhotoDTO>recipePhotoDTOList = mapper.recipPhoto(recipeNum);
        recipeviewDTO.setRecipePhotoDTOList(recipePhotoDTOList);
        recipeviewDTO.setRecipeOrderList(recipeOrderDTOList);
        return recipeviewDTO;
    }



    public List<CommentReadDTO> commentRead(int recipeNum) {
        List<CommentReadDTO>  commentReadDTOList = mapper.commentRead(recipeNum);
        return commentReadDTOList;
    }

    public int viewCount(int recipeNum) {
        int result = mapper.viewCount(recipeNum);
        return result;
    }

    public String getUserName(int recipeNum) {
        String name = mapper.getUserName(recipeNum);
        return name;
    }

    public int recipeDelete(int recipe) {
        int result = mapper.recipeDelete(recipe);
        return result;
    }

    public int writeRecipe(RecipeWriteDTO recipeWriteDTO) {

        int result = 0;
        try{
            result = mapper.writeRecipe(recipeWriteDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

