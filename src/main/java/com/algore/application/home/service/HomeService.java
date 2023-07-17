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

    public List<MainViewDTO> mainView(int startIndex, int pageSiz , int page) {
        List<MainViewDTO> mainViewDTOList = mapper.mainView(startIndex, pageSiz ,page);
        return mainViewDTOList;
    }

    public int allcnt() {
        int totaListCnt = mapper.allcnt();
        return totaListCnt;
    }

}
