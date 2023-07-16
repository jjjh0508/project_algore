package com.algore.application.qna.controller;

import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/qna")
public class QnAController {

    private final QuestionService main;
    private final QuestionService detail;

    public QnAController(QuestionService main, QuestionService detail) {
        this.main = main;
        this.detail = detail;
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv) {
        List<QuestionDTO> lists = main.questionAll();
        for (QuestionDTO questionDTO: lists) {
            System.out.println(questionDTO);
        }
        mv.addObject("mainList" , lists);
        mv.setViewName("qna/main");

        return mv;
    }

    @GetMapping("/read")
    public ModelAndView read(ModelAndView mv) {
        List<QuestionDTO> lists = detail.detaileRead();
        mv.addObject("detailList", lists);
        mv.setViewName("qna/read");
        return mv;
    }

    @GetMapping("/adminwriteanswer")
    public void adminwriteanswer() {
    }

    //유저 질문
    @GetMapping("userwritequestion")
    public void userwritequestion() {
    }

    //유저 상세글
    @GetMapping("userupdatequestion")
    public void userupdatequestion() {
    }

}
