package com.algore.application.user.controller;

import com.algore.application.user.dto.UserMemberDTO;
import com.algore.application.user.service.JoinService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class JoinController {
    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @Value("${open-api.key}")
    private String apikey;

    @GetMapping("/memberList")
    public ModelAndView selectAll(ModelAndView mv){ //프론트 화면
        List<UserMemberDTO> memberList = joinService.selectAll();

        mv.addObject("memberList", memberList);

        mv.setViewName("user/memberList");
        return mv;
    }

    public JoinService getJoinService() {
        return joinService;
    }
}
