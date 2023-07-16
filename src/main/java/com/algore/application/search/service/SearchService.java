package com.algore.application.search.service;

import com.algore.application.home.dto.MainViewDTO;
import com.algore.application.search.dao.SearchMapper;
import com.algore.application.search.dto.SearchDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SearchService {

    private final SearchMapper mapper;

    public SearchService(SearchMapper mapper) {

        this.mapper = mapper;
    }

    public List<SearchDTO> searchRecipe(String recipeName) {
        List<SearchDTO> mainViewDTOList = mapper.searchRecipe(recipeName);
        return mainViewDTOList;
    }
}
