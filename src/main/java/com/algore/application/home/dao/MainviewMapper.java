package com.algore.application.home.dao;

import com.algore.application.home.dto.MainViewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainviewMapper {

    List<MainViewDTO> mainView();


    List<MainViewDTO> mainView(@Param("startIndex")int startIndex , @Param("pageSiz")int pageSiz, @Param("page") int page);

    int allcnt();

}
