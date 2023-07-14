package com.algore.application.qna.service;

import com.algore.application.qna.dao.QuestionMapper;
import com.algore.application.qna.dto.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
    public List<QuestionDTO> questionAll(){
        List<QuestionDTO> allQuestion = questionMapper.questionAll();

        return allQuestion;
    }


}
