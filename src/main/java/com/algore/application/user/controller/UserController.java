package com.algore.application.user.controller;

import com.algore.application.user.dto.UserMemberDTO;
import com.algore.application.user.service.UserMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserMemberService userMemberService;

    public UserController(UserMemberService userMemberService) {
        this.userMemberService = userMemberService;
    }

    @GetMapping("/login")
    public String main(){
        return "user/login";
    }


    @GetMapping("/list")
    public ModelAndView selectAll(ModelAndView mv) {
        List<UserMemberDTO> userList = userMemberService.userList();
        for (UserMemberDTO userMemberDTO: userList) {
            System.out.println(userMemberDTO);
        }
        mv.addObject("userList", userList );
        mv.setViewName("user/memberlist");
        return mv;
    }

    @GetMapping("/idfind")
    public String idfind() {
        return "user/idfind";
    }

    @GetMapping("/idfindresult")
    public String idfindresult() {
        return "user/idfindresult";
    }


    @GetMapping("/passfind")
    public String passfind() { return "user/passfind"; }

    @GetMapping("/passsendcode")
    public String passsendcode() {
        return "user/passsendcode";
    }

    @GetMapping("/passinputcode")
    public String passinputcode() {
        return "user/passinputcode";
    }

    @GetMapping("/passreset")
    public String passreset() {
        return "" + "";
    }

    @GetMapping("join")
    public String join() {
        return "user/join";
    }

}
