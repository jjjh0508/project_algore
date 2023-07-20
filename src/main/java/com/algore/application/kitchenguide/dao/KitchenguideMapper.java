package com.algore.application.kitchenguide.dao;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //데이터베이스 쿼리 짜주는 역할
public interface KitchenguideMapper {


    TrimDTO trimPostRead/*mapper.xml id랑 매핑*/(int trimNum); //손질법 게시글 조회(손질법 제목, 내용, 동영상URL)
    List<TrimProcedureDTO>/*mapper.xml id랑 매핑*/ trimProPostRead(int trimNum); //손질법 게시글 조회(손질 순서)

    // xml 매칭 insertPost Trim테이블에서 값 넣어주기 int?
    int insertTrim(TrimDTO trimDTO);

    int insertTrimProduce(TrimProcedureDTO trimProcedureDTO);


    int trimPostViewCount/*mapper.xml id랑 매핑*/(int trimNum); // 조회수

    List<TrimDTO> trimPostMain(); //메인화면

    int trimPostDelete(int trimNum); //손질법 게시글 삭제
}
