package com.algore.application.home.service;

import com.algore.application.home.dao.MainviewMapper;
import com.algore.application.home.dto.MainViewDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final MainviewMapper mapper;

    public HomeService(MainviewMapper mapper) {
        this.mapper = mapper;
    }

    public List<MainViewDTO> mainView() {
        List<MainViewDTO> mainViewDTOList = mapper.mainView();
        return mainViewDTOList;
    }


    public List<MainViewDTO> searchRecipe(String recipeName) {
        List<MainViewDTO> mainViewDTOList = mapper.searchRecipe(recipeName);
        return mainViewDTOList;
    }
}
