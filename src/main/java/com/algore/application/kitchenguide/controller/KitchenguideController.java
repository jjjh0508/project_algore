package com.algore.application.kitchenguide.controller;


import com.algore.application.employee.dto.InputContentDTO;
import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/kitchenguide") //@RequestMapping : view의 요청 경로 지정
public class KitchenguideController {


    private final KitchenguideService kitchenguideService;
    public KitchenguideController(KitchenguideService kitchenguideService) {
    public KitchenguideController(KitchenguideService kitchenguideService) { /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/
        this.kitchenguideService = kitchenguideService;
    }

    @GetMapping("/mainview")
    public String mainview() {
        return "/kitchenguide/mainview";
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

    @GetMapping("/trimwrite")
    public String trimwrite() {
        return "/kitchenguide/trimwrite";
    }

    @PostMapping("/trimwrite")
    public ModelAndView insertTrim(ModelAndView mv, TrimDTO trimDTO, HttpServletRequest req){

        System.out.println(trimDTO);
        String backUrl = req.getHeader("Referer");

        int result = kitchenguideService.insertPost(trimDTO);

        String path = " ";

        if (result > 0) {
            mv.addObject("message", "등록이 완료되었습니다.");
            mv.setViewName("redirect:/kitchenguide/trimread");
        }else {
            mv.addObject("message", "등록에 실패하였습니다.");
            mv.setViewName("redirect:"); // 수정하기
        }
        return mv;
    }

//    @GetMapping("/file")
//    public void goFile(){}
//
//     수정하기
//    @PostMapping("/file")
//    public ModelAndView insertFile(@ModelAttribute ??? dto?, HttpServletRequest request){
//        // 파일을 입력 받고 해당 파일을 로컬에 저장한 뒤 저장된 경로를 데이터 베이스에 저장한 다음 해당 포스팅을 불러올때 이미지 경로에 경로를 넣어준다
//        ModelAndView modelAndView = new ModelAndView();
//
//        // 사용자의 이전 요청 값을 확인한다
//        String backUrl = request.getHeader("Refere");
//
//        // 파일 확장자 가져오기
//        MultipartFile fileOne = ????.getInputFile();
//        String ext = fileOne.getOriginalFilename().substring(fileOne.getOriginalFilename().indexOf(","));
//
//        // 파일 확장자가 이미지 확장자가 아닌 경우
//        if(!(ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg"))){
//            modelAndView.addObject("messege", "이미지가 아닙니다");
//            modelAndView.setViewName(backUrl);
//
//            return modelAndView;
//        }
//
//        if(??.getInputFile() != null){
//            String originFilePath = "\\upload\\basic";
//            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static" + originFilePath; // 프로그램 내부 경로
//
//            File originDirectory = new File(path);
//
//            if(!originDirectory.exists()){ // 해당 경로의 폴더가 없는 경우
//                originDirectory.mkdirs();  // 해당 폴더를 만들어
//            }
//
//            // 파일명 변경
//
//            // 파일 저장경로에 파일 이름 추가
//            path += ??.getInputFile().getOriginFilename();
//
//            // 파일 저장
//
//        }
//    }

}
