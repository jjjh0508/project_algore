package com.algore.application.home.dao;

import com.algore.application.home.dto.MainViewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainviewMapper {

    List<MainViewDTO> mainView();


    List<MainViewDTO> mainView(int startIndex , int pageSiz, int page);

    int allcnt();

}
