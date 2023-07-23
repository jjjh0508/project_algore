package com.algore.application.user.controller;

import com.algore.application.user.dto.UserMemberDTO;
import com.algore.application.user.service.JoinService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @Value("${open-api.key}")
//    private String apikey;

    @GetMapping("/memberList")
    public ModelAndView selectAll(ModelAndView mv) { //프론트 화면
        List<UserMemberDTO> memberList = joinService.selectAll();

        mv.addObject("memberList", memberList);

        mv.setViewName("user/memberList");
        return mv;
    }

//    @GetMapping("/regist")
//    public JoinService getJoinService() {
//        return joinService;
//    }

    @GetMapping("/join")
    public void join(){}

    @GetMapping("login")
    public void login(){}

    @PostMapping(value = "/regist")
    public ModelAndView registMember(ModelAndView model, UserMemberDTO insertUserMemberDTO) {
        System.out.println(insertUserMemberDTO);

        int result = joinService.registUser(insertUserMemberDTO);
        
        if(result>0){
            System.out.println("성공");
            model.setViewName("user/login");
        }else {
            System.out.println("실패");
        }

        return model;
    }
//    @GetMapping("login")
//    public ModelAndView layout( ModelAndView mv){
//        mv.setViewName("user/login");
//        return mv;
//    }
}
