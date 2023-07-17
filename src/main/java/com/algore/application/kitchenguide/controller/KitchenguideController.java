package com.algore.application.kitchenguide.controller;


import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/kitchenguide") //@RequestMapping : view의 요청 경로 지정
public class KitchenguideController {


    private final KitchenguideService kitchenguideService;
    /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/
    public KitchenguideController(KitchenguideService kitchenguideService) {
        this.kitchenguideService = kitchenguideService;
    }

    @GetMapping("/mainview")
    public String mainview() {
        return "/kitchenguide/mainview";
    }

    @GetMapping("/trimwrite")
    public String trimwrite() {
        return "/kitchenguide/trimwrite";
    }

    @PostMapping("/trimwrite")
    public ModelAndView insertTrim(ModelAndView mv, TrimDTO trimDTO, HttpServletRequest req){

        System.out.println(trimDTO);
        String backUrl = req.getHeader("Referer");

        int result = kitchenguideService.insertPost(trimDTO);

//        String path = " ";

        if (result > 0) {
            mv.addObject("message", "등록이 완료되었습니다.");
            mv.setViewName("redirect:/kitchenguide/trimread");
        }else {
            mv.addObject("message", "등록에 실패하였습니다.");
            mv.setViewName("redirect:/kitchenguide/trimwrite");
        }
        return mv;
    }

    @GetMapping("/trimread/{trimNum}")
    public ModelAndView trimread(ModelAndView mv, @PathVariable("trimNum") int trimNum,
                                 Authentication authentication, HttpServletRequest request,
                                 HttpServletRequest response) {
        List<TrimDTO> procedure = kitchenguideService.readPost();

        mv.setViewName("kitchenguide/trimread"); //응답할 뷰의 경로 설정
        mv.addObject("변수이름", "데이터 값"); //데이터 전송("변수이름", "데이터 값");

        return mv; //ModelAndView 객체 반환
    }

}
