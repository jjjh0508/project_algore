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

    public List<SearchDTO> searchRecipe(String recipeName, int startIndex ,int pageSiz,int page) {
        List<SearchDTO> mainViewDTOList = mapper.searchRecipe(recipeName,startIndex,pageSiz,page);
        return mainViewDTOList;
    }

    public int searchCnt(String recipeName) {
        int totaListCnt = mapper.searchCnt(recipeName);
        return totaListCnt;
    }
}
