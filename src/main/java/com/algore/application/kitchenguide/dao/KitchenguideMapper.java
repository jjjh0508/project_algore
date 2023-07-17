package com.algore.application.kitchenguide.dao;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //데이터베이스 쿼리 짜주는 역할
public interface KitchenguideMapper {

    List<TrimDTO> readPost();

    int insertPost(TrimDTO trimDTO);
}
