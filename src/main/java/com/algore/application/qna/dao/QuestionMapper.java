package com.algore.application.qna.dao;

import com.algore.application.qna.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface QuestionMapper {
    List<QuestionDTO> questionAll();
    QuestionDTO detaileRead(int qNumber);
}