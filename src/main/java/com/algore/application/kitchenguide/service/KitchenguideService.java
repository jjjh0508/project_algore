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
        TrimDTO trimDTO = mapper.trimPostRead(trimNum); //매퍼호출
        return trimDTO;
    }

    /**/
    public List<TrimProcedureDTO> readPost(int trimNum) {
        List<TrimProcedureDTO> procedure = mapper.trimProPostRead(trimNum);
        return procedure;
    }

    /* @Transactional : 스프링 프레임워크에서 제공하는 어노테이션, 데이터베이스 트랜잭션 관리를 위해서 사용 */
    @Transactional
    public int insertTrim(TrimDTO trimDTO) {
        /* 손질법 등록
         *  KitchenguideMapper에 있는 insertTrim (Trim 테이블에 있는 값 넣어주기)를
         *  result에 실행 결과 담기 1 : 성공 0 : 실패 */
        int result = mapper.insertTrim(trimDTO);

        if (result > 0) {
            /* result가 0보다 클 때 (즉 손질법이 등록 되었을 때)
             *
             *  손질법순서 등록 후 result에 실행 결과 담기
             * */
            List<TrimProcedureDTO> trimProcedure = trimDTO.getTrimProcedureDTOList(); // 손질법 순서 객체 담고 있는 리스트 = trim 객체에서 손질법 순서(TrimProcedureDTO) 객체들을 가져오는 메서드
            if (trimProcedure != null && !trimProcedure.isEmpty()) {
                for (TrimProcedureDTO procedureDTO : trimProcedure) {
                    /* trimNum : 손질법과 손질법 순서를 연결하는 역할
                     *  result : 손질법 등록 결과로서 등록된 손질법의 번호 trimNum이 담겨 있다
                     *  등록된 손질법의 번호 가져와서 trimNum으로 설정
                     *
                     * 손질법 순서 객체의 trimNum을 손질법 등록 후에 발급받은 해당 손질법의 번호(result)로 설정
                     * */
                    procedureDTO.setTrimNum(result);
                    mapper.insertTrimProduce(trimProcedure);
                }
            }
            return result;
        }
        return result;
    }



    public int trimPostViewCount(int trimNum) {
        int result = mapper.trimPostViewCount(trimNum);
        return trimNum;
    }

    public List<TrimDTO> mainPost() { //메인화면
        List<TrimDTO> dtomainList = mapper.trimPostMain();
        return dtomainList;
    }

    public int deleteTrimPost(int trimNum) {
        int deleted = mapper.trimPostDelete(trimNum); //매퍼호출
        return trimNum;
    }

    public TrimDTO trimUpdatePost(int trimNum) {
        TrimDTO trimDTO = mapper.trimPostUpdate(trimNum);
        return trimDTO;
    }
}


