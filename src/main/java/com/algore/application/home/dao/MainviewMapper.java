package com.algore.application.home.dao;

import com.algore.application.home.dto.MainViewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainviewMapper {
<<<<<<< HEAD
    List<MainViewDTO> mainView();

    List<MainViewDTO> searchRecipe(String recipeName);
=======
    List<MainViewDTO> mainView(int startIndex , int pageSiz, int page);

    int allcnt();
>>>>>>> f50c9103cdddebbd6df0a81796ce072c28286e67
}
