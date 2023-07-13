package com.algore.application.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @GetMapping("/main")
    public void main() {
    }

    @GetMapping("/write")
    public void write() {
    }

    @GetMapping("/read")
    public String read() {
        return "notice/read";
    }

}
