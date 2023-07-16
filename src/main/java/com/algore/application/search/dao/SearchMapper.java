package com.algore.application.search.dao;

import com.algore.application.home.dto.MainViewDTO;
import com.algore.application.search.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<SearchDTO> searchRecipe(String recipeName);
}
