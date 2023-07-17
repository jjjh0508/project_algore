package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeViewMapper;
import com.algore.application.recipe.dto.CommentReadDTO;
import com.algore.application.recipe.dto.RecipeOrderDTO;
import com.algore.application.recipe.dto.RecipePhotoDTO;
import com.algore.application.recipe.dto.RecipeviewDTO;
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
        return recipeviewDTO;
    }

    public List<RecipeOrderDTO> recipeOrder(int recipeNum) {

        List<RecipeOrderDTO>recipeOrderDTOList = mapper.recipeOrder(recipeNum);
        return recipeOrderDTOList;
    }

    public List<RecipePhotoDTO> recipPhoto(int recipeNum) {
        List<RecipePhotoDTO>recipePhotoDTOList = mapper.recipPhoto(recipeNum);
        return recipePhotoDTOList;
    }

    public List<CommentReadDTO> commentRead(int recipeNum) {
        List<CommentReadDTO>  commentReadDTOList = mapper.commentRead(recipeNum);
        return commentReadDTOList;
    }

    public int viewCount(int recipeNum) {
        int result = mapper.viewCount(recipeNum);
        return result;
    }

    public String modifyName(int recipeNum) {
        String name = mapper.modifyName(recipeNum);
        return name;
    }

    public int recipeDelete(int recipe) {
        int result = mapper.recipeDelete(recipe);
        return result;
    }
}
