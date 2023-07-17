package com.algore.application.kitchenguide.service;

import com.algore.application.kitchenguide.dao.KitchenguideMapper;
import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //어노테이션을 붙이지 않을 경우 bean으로 등록해주지 않음
public class KitchenguideService {

    private final KitchenguideMapper mapper;
    public KitchenguideService(KitchenguideMapper mapper) {
        /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/
        this.mapper = mapper;
    }

    public TrimDTO readTrim(int trimNum/*게시글번호*/) {
        /* mapper 연결하여 dto 값 받아오기 */
        TrimDTO trimDTO = mapper.readTrim(trimNum); //매퍼호출
        return trimDTO;
    }

    /**/
    public List<TrimProcedureDTO> readPost(int trimNum) {
        List<TrimProcedureDTO> procedure = mapper.readPost(trimNum);
        return procedure;
    }


    public int insertPost(TrimDTO trimDTO) {
        int result = 0;

        try {
            result = mapper.insertPost(trimDTO);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int viewCount(int trimNum) {
        int result = mapper.viewCount(trimNum);
        return trimNum;
    }
}
