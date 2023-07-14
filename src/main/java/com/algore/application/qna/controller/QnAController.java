package com.algore.application.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qna")
public class QnAController {

    @GetMapping("/main")
    public String main() {
        return "qna/main";
    }

    @GetMapping("/read")
    public String read() {
        return "qna/read";
    }

    @GetMapping("/adminwriteanswer")
    public void adminwriteanswer() {
    }

    @GetMapping("userwritequestion")
    public void userwritequestion() {
    }

    @GetMapping("userupdatequestion")
    public void userupdatequestion() {
    }

}
