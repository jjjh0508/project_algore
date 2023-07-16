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

<<<<<<< HEAD

=======
    public int allcnt() {
        int totaListCnt = mapper.allcnt();
        return totaListCnt;
    }
>>>>>>> f50c9103cdddebbd6df0a81796ce072c28286e67

}
