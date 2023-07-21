package com.algore.application.qna.service;

import com.algore.application.qna.dao.QuestionMapper;
import com.algore.application.qna.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionMapper questionMapper;
    private final QuestionMapper detailMapper;

    //메인화면 서비스
    public QuestionService(QuestionMapper questionMapper, QuestionMapper detailMapper) {
        this.questionMapper = questionMapper;
        this.detailMapper = detailMapper;
    }
    //전체글 main
    public List<QuestionDTO> questionAll(){
        List<QuestionDTO> allQuestion = questionMapper.questionAll();

        return allQuestion;
    }

    public List<QuestionDTO> detaileRead(int qNumber) {
        List<QuestionDTO> list = detailMapper.detaileRead(qNumber);
        return list;
    }


    




}