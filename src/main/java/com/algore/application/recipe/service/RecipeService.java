package com.algore.application.recipe.service;

import com.algore.application.recipe.dao.RecipeViewMapper;
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
}
