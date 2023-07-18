package com.algore.application.kitchenguide.service;

import com.algore.application.kitchenguide.dao.KitchenguideMapper;
import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public int insertPost(TrimDTO trimDTO) {
        /* 손질법 등록
        *  손질법순서 등록*/

        /* KitchenguideMapper에 있는 insertPost (Trim 테이블에 있는 값 넣어주기)를
        *  result에 실행결과 담기 1 : 성공 0 : 실패 */
        int result = mapper.insertTrim(trimDTO);


        if(result > 0){
            /* result가 0보다 클때 (즉 손질법이 등록되었을때) */
            /* 손질법순서 등록*/
//            result = mapper.insertTrimProduce(trimProcedureDTO);
        }
        return result;
    }


    public int viewCount(int trimNum) {
        int result = mapper.viewCount(trimNum);
        return trimNum;
    }

    public List<TrimDTO> mainPost() { //메인화면
        List<TrimDTO> dtomainList = mapper.mainPost();
        return dtomainList;
    }

    public int deleteTrimPost(int deleteNum) {
        System.out.println("trimNum : " + deleteNum);
        int deleted = mapper.deleteTrimPost(deleteNum); //매퍼호출

        return deleted;
    }
}
