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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/kitchenguide") //@RequestMapping : view의 요청 경로 지정
public class KitchenguideController {

    private final KitchenguideService kitchenguideService;
    public KitchenguideController(KitchenguideService kitchenguideService) { /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/
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


    /*레시피 읽기(read)*/
    @GetMapping("/trimread/{trimNum}") //사용자가 get 방식으로 /kitchenguide/trimread을 요청할 경우 실행, {동적으로 바뀔 수 있는 값}
    public ModelAndView trimread(ModelAndView mv, @PathVariable("trimNum") int trimNum/*손질번호*/, HttpServletRequest request/*요청*/, HttpServletResponse response/*응답*/) {

        System.out.println(trimNum);

        /* Service에서 불러오기 */
        TrimDTO trimDTO = kitchenguideService.readTrim(trimNum); //손질제목, 동영상URL, 손질내용
        List<TrimProcedureDTO> procedureList = kitchenguideService.readPost(trimNum); //손질순서 list 값으로 받아오기

        /* 데이터 전송("변수이름", "데이터 값"); */
        /* html문서에서 타임리프 ${변수이름.dto(필드)이름} ---> 이렇게 사용하기...*/
        mv.addObject("trimDTO", trimDTO); //손질제목, 동영상URL, 손질내용
        mv.addObject("procedureList", procedureList); //손질순서(List)

        for (TrimProcedureDTO trimProcedureDTO : procedureList){
            System.out.println(trimProcedureDTO);
        }

        /* 응답할 뷰의 경로 설정(리턴값) */
        mv.setViewName("/kitchenguide/trimread");
        return mv; //ModelAndView 객체 반환
    }

}
