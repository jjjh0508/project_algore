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
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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

    @GetMapping("/trimupdate/{trimNum}") //손질법 게시글 수정(관리자 권한) - 페이지 수정 폼 컨트롤러
    public ModelAndView trimupdate(ModelAndView mv, @PathVariable("trimNum") int trimNum/*손질번호*/) {
        
        /* 파라미터를 넘겨주는 방법
          1. @PathVariable 사용
            -> (ex. localhost:8080/kitchenguide/trimupdate/1)의 형식
            -> trimNum이라는 값을 매개변수로 넘겨 쿼리 스트링 형식이 아닌 특정 숫자 그 자체로의 조회
          2. 쿼리 스트링 사용
            -> (ex. localhost:8080/kitchenguide/trimupdate?trimNum=1)의 형식 */

        /* Service 로직에서 불러오기 */
        TrimDTO trimDTO = kitchenguideService.readTrim(trimNum);
        List<TrimProcedureDTO> procedureList = kitchenguideService.readPost(trimNum);

        /* 데이터 전송("변수이름", "데이터 값");
         *  html 문서에서 타임리프 ${변수이름.dto(필드}이름}  ->  이렇게 사용하기 */
        mv.addObject("trimDTO", trimDTO); //손질법 제목, 내용, 동영상URl
        mv.addObject("procedureList", procedureList); //손질법 순서

        /*기존 값 읽어오는지 확인하기...*/
        System.out.println("trimupdate Controller : " + trimDTO);
        System.out.println("trimupdate Controller : " + procedureList);

        mv.setViewName("/kitchenguide/trimupdate"); //응답할 뷰의 경로 설정 (리턴 값)
        return mv;
    }

    @PostMapping("/trimupdate/{trimNum}") //손질법 게시글 수정(관리자 권한) - 수정 시 작동하는 컨트롤러
    public ModelAndView trimupdatepost(ModelAndView mv, TrimDTO trimDTO, TrimProcedureDTO trimProcedureDTO,
                                       HttpServletRequest request/*요청*/, HttpServletResponse response/*응답*/,
                                       @RequestParam("trimTitle") String trimTitle/*손질제목*/,
                                       @RequestParam("trimDetail") String trimDetail/*손질내용*/,
                                       @RequestParam("trimVideoLink") String trimVideoLink/*동영상링크*/,
                                       @RequestParam("tpFileName") List<MultipartFile> fileOne/*파일 저장해주기*/) {

        System.out.println("post/trimupdate controller 실행됨--------------------------------");

        /*TrimDTO*/
        trimDTO.setTrimTitle(trimTitle); //손질 제목
        trimDTO.setTrimDetail(trimDetail); //손질 내용
        trimDTO.setTrimVideoLink(trimVideoLink); //동영상링크

        /*매퍼 연결*/
        int result = kitchenguideService.trimUpdatePost(trimDTO);

        /*값 제대로 받아오는지 확인*/
        System.out.println("trimTitle : " + trimTitle);
        System.out.println("trimDetail : " + trimDetail);
        System.out.println("trimVideoLink : " + trimVideoLink);

        String root = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\basic\\";
        /*파일 이름 중복을 방지하기 위한 초단위 파일명*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        MultipartFile trimFile = trimProcedureDTO.getTrimInputFile();



        /*파일 이름만 담아서 dto로 보내주기....*/


        mv.setViewName("/kitchenguide/trimread/{trimNum}");
        return mv;
    }

    @GetMapping("/delete/{trimNum}") //손질법 게시글 삭제
    public ModelAndView deleteTrimPost(ModelAndView mv, @PathVariable("trimNum") int deleteNum/*손질번호*/) {

        System.out.println("con t : " + deleteNum);
        int deleted = kitchenguideService.deleteTrimPost(deleteNum);

        mv.setViewName("redirect:/kitchenguide/mainview");
        return mv;
    }


    @GetMapping("/trimread/{trimNum}") //사용자가 get 방식으로 /kitchenguide/trimread를 요청할 경우 실행, {동적으로 바뀔 수 있는 값}
    public ModelAndView trimread(ModelAndView mv, @PathVariable("trimNum") int trimNum/*손질번호*/, HttpServletRequest request/*요청*/, HttpServletResponse response/*응답*/) {

        /* 조회수 */
        trimPostViewCount(request, response, trimNum);

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

    private void trimPostViewCount(HttpServletRequest request, HttpServletResponse response, int trimNum) {
        /* 조회수 */
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
                kitchenguideService.trimPostViewCount(trimNum);
                oldCookie.setValue(oldCookie.getValue() + "_[" + trimNum + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(oldCookie);
            }
        } else {
            kitchenguideService.trimPostViewCount(trimNum);
            Cookie newCookie = new Cookie("view", "[" + trimNum + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 24);
            response.addCookie(newCookie);
        }
    }

    @GetMapping("/trimwrite") //사용자가 get 방식으로 /kitchenguide/trimwrite를 요청할 경우 실행
    public String trimwrite() {
        return "kitchenguide/trimwrite";
    }

    /* HttpServletRequest : 현재 요청에 대한 정보를 담고 있는 HttpServletRequest 객체, 클라이언트의 요청 정보를 확인하거나 추가적인 작업을 수행할 수 있다
    *  ModelAndView : Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장*/
    @PostMapping("/trimwrite") //사용자가 post 방식으로 /kitchenguide/trimwrite를 요청할 경우 실행
    public ModelAndView insertTrim(ModelAndView mv,TrimDTO trimDTO) {
//        손질법 등록 확인
//        System.out.println("trimNum");
//        System.out.println("trimTitle");
//        System.out.println("trimDetail");
//        System.out.println("trimViews");
//        System.out.println("trimVideoLink");
//        System.out.println(trimDTO); // 제목, 내용, 동영상URL ok, (번호 : 0 , 조회수 : 0, 상태 : null x)

        /* KitchenguideService에 있는 insertTrim (Trim 테이블에 있는 값 넣어주기)를
         *  result에 실행 결과 담기 1 : 성공 0 : 실패*/
        int result = kitchenguideService.insertTrim(trimDTO);

        if (result > 0) {
            /* 손질법 등록 성공
            *  result가 0보다 클 때
            *  view에 전달할 값 설정 (데이터 보낼 때)
            *  mv.addObject("변수 이름", "데이터 값");
            * */
            mv.addObject("message", "등록이 완료되었습니다.");
            /* 응답할 view 이름 설정
            *  mv.setViewName("뷰의 경로");*/
            mv.setViewName("redirect:kitchenguide/trimread");
        } else {
            /* 손질법 등록 실패
            * result가 0보다 크지 않을 때
            * */
            mv.addObject("message", "등록에 실패하였습니다.");
            mv.setViewName("redirect:kitchenguide/trimread");
        }
        return mv;
    }


//    @GetMapping("/file")
//    public void goFile(){}
//
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
