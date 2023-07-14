package com.algore.application.kitchenguide.service;

import com.algore.application.kitchenguide.dao.KitchenguideMapper;
import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //어노테이션을 붙이지 않을 경우 bean으로 등록해주지 않음
public class KitchenguideService {

    private final KitchenguideMapper kitchenguideMapper;
    /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/

    public KitchenguideService(KitchenguideMapper kitchenguideMapper) {
        this.kitchenguideMapper = kitchenguideMapper;
    }

    /**/
    public List<TrimDTO> readPost() {
        List<TrimDTO> procedure = kitchenguideMapper.readPost();
        return procedure;
    }
}
