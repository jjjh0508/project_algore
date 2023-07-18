package com.algore.application.kitchenguide.controller;


import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/kitchenguide") //@RequestMapping : view의 요청 경로 지정
public class KitchenguideController {


    private final KitchenguideService kitchenguideService;

    public KitchenguideController(KitchenguideService kitchenguideService) { /*final은 기본값이 없기 때문에 초기화를 통해 값을 등록해 주어야함*/
        this.kitchenguideService = kitchenguideService;
    }

    @GetMapping("/mainview") //메인 화면
    public ModelAndView mainview(ModelAndView mv, HttpServletRequest request/*요청*/, HttpServletResponse response) {

        List<TrimDTO> dtomainList = kitchenguideService.mainPost();

        mv.addObject("dtomainList", dtomainList); //메인사진, 제목 가져오기

        mv.setViewName("/kitchenguide/mainview");
        return mv;
    }

    @GetMapping("/delete/{trimNum}") //손질법 게시글 삭제
    public ModelAndView deleteTrimPost(ModelAndView mv, @PathVariable("trimNum") int trimNum/*손질번호*/) {

        /* th:href="'/kitchenguide/delete/'+${trimNum}"에서 받아온 trimNum 값 int에 넣어주기...
        * 타고타고 넘어가서 xml 파일에 trimNum 값으로 넣어준다...*/
        int delete = kitchenguideService.deleteTrimPost(trimNum);

        /* 삭제 후 손질 법 메인화면으로 복귀 */
        mv.setViewName("redirect:/kitchenguide/mainview");
        return mv;
    }


    @GetMapping("/trimread/{trimNum}") //사용자가 get 방식으로 /kitchenguide/trimread를 요청할 경우 실행, {동적으로 바뀔 수 있는 값}
    public ModelAndView trimread(ModelAndView mv, @PathVariable("trimNum") int trimNum/*손질번호*/, HttpServletRequest request/*요청*/, HttpServletResponse response/*응답*/) {

        /* 조회수 */
        viewCount(request, response, trimNum);

        /* Service 로직에서 불러오기 */
        TrimDTO trimDTO = kitchenguideService.readTrim(trimNum);
        List<TrimProcedureDTO> procedureList = kitchenguideService.readPost(trimNum);

        /* 데이터 전송("변수이름", "데이터 값");
         *  html 문서에서 타임리프 ${변수이름.dto(필드}이름}  ->  이렇게 사용하기 */
        mv.addObject("trimDTO", trimDTO); //손질법 제목, 내용, 동영상URl
        mv.addObject("procedureList", procedureList); //손질법 순서

        mv.setViewName("kitchenguide/trimread"); //응답할 뷰의 경로 설정 (리턴 값)
        return mv; //ModelAndView 객체 반환
    }

    private void viewCount(HttpServletRequest request, HttpServletResponse response, int trimNum) {

        Cookie oldCookie = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("view")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + trimNum + "]")) {
                kitchenguideService.viewCount(trimNum);
                oldCookie.setValue(oldCookie.getValue() + "_[" + trimNum + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            kitchenguideService.viewCount(trimNum);
            Cookie newCookie = new Cookie("view", "[" + trimNum + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }

    @GetMapping("/trimwrite")
    public String trimwrite() {
        return "kitchenguide/trimwrite";
    }

    // 경로 수정해주기 redirect:
    @PostMapping("/trimwrite")
    public ModelAndView insertTrim(ModelAndView mv, TrimDTO trimDTO, HttpServletRequest req) {

        String backUrl = req.getHeader("Referer");

        int result = kitchenguideService.insertPost(trimDTO);

        String path = " ";

        if (result > 0) {
            mv.addObject("message", "등록이 완료되었습니다.");
            mv.setViewName("redirect:kitchenguide/trimread");
        } else {
            mv.addObject("message", "등록에 실패하였습니다.");
            mv.setViewName("redirect:kitchenguide/trimread");
        }
        return mv;
    }

    @GetMapping("/file")
    public void goFile(){}

//    @PostMapping("/file")
//    public ModelAndView insertFile(@ModelAttribute InputDTO input, HttpServletRequest request) {
//        // 파일을 입력 받고 해당 파일을 로컬에 저장한 뒤 저장된 경로를 데이터 베이스에 저장한 다음 해당 포스팅을 불러올때 이미지 경로에 경로를 넣어준다
//        ModelAndView modelAndView = new ModelAndView();
//
//        // 사용자의 이전 요청 값을 확인한다
//        String backUrl = request.getHeader("Refere");
//
//        // 파일 확장자 가져오기
//        MultipartFile fileOne = input.getInputFile();
//        String ext = fileOne.getOriginalFilename().substring(fileOne.getOriginalFilename().indexOf(","));
//
//        // 파일 확장자가 이미지 확장자가 아닌 경우
//        if (!(ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg"))) {
//            modelAndView.addObject("messege", "이미지가 아닙니다");
//            modelAndView.setViewName(backUrl);
//
//            return modelAndView;
//        }
//
//        // 업로드 된 파일이 존재하는 경우
//        if (input.getInputFile() != null) {
//            String originFilePath = "\\upload\\basic"; // 원본 파일이 저장될 폴더의 상대 경로
//            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static" + originFilePath; // 프로그램 내부 경로
//
//            File originDirectory = new File(path);
//
//            if (!originDirectory.exists()) { // 해당 경로의 폴더가 없는 경우
//                originDirectory.mkdirs();  // 폴더가 존재하지 않는 경우에만 폴더 생성
//            }
//
//            // 파일명 변경
//
//            /* 파일 저장경로에 파일 이름 추가
//            *  최종 파일 저장 경로에 업*/
//            path += input.getInputFile().getOriginalFilename();
//
//            // 파일 저장
//            try {
//                /* 업로드된 파일을 최종 파일 저장 경로에 저장*/
//                input.getInputFile().transferTo(new File(path));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            modelAndView.addObject("message", "파일 저장 성공");
//        } else {
//            modelAndView.addObject("message", "파일 저장 실패");
//            return  modelAndView;
//        }
//        modelAndView.setViewName("index");
//
//        return modelAndView;
//    }
}
