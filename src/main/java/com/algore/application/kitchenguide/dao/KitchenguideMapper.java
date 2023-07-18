package com.algore.application.kitchenguide.dao;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //데이터베이스 쿼리 짜주는 역할
public interface KitchenguideMapper {


    TrimDTO readTrim/*mapper.xml id랑 매핑*/(int trimNum); //손질법 제목, 내용, 동영상URL
    List<TrimProcedureDTO>/*mapper.xml id랑 매핑*/ readPost(int trimNum); //손질 순서

    int insertPost(TrimDTO trimDTO);


    int viewCount/*mapper.xml id랑 매핑*/(int trimNum); // 조회수

    List<TrimDTO> mainPost(); //메인화면
}
