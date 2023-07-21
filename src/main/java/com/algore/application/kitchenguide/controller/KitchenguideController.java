package com.algore.application.kitchenguide.controller;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
=======
import java.text.SimpleDateFormat;
>>>>>>> 4249339d0cca744a22ac62c1fd7971ea838cf4bd
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

    /* ModelAndView : Controller 처리 결과 후 응답할 view와 view에 전달할 값을 저장
    *  @RequestParam : HttpServletRequest 객체와 같은 역할을 한다 (HttpServletRequest의 request.getParameter의 기능과 동일)
    *
    * "tpFileName" = html(화면) name과 동일해야 함
    * List<MultipartFile> fileName : 클라이언트가 업로드한 파일 데이터를 받기 위한 매개변수
    * RedirectAttributes : 리다이엑트 시에 데이터를 전달하기 위한 객체
    * */
    @PostMapping("/trimwrite") //사용자가 post 방식으로 /kitchenguide/trimwrite를 요청할 경우 실행
    @ResponseBody
    public ModelAndView insertTrim(ModelAndView mv, TrimDTO trimDTO, @RequestParam(value = "tpFileName", required = false)
                                List<MultipartFile> fileName, RedirectAttributes redirectAttributes){
//      사진 등록 확인
        System.out.println(fileName.get(0).getOriginalFilename());
        System.out.println(fileName.get(1).getOriginalFilename());

//      현재 어플리케이션의 작업 리덱토리에서 정적 리소스 파일들을 저장할 경로를 지정
        String root = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\basic\\";
//      파일 이름 중복을 피하기 위해 현재 시간 기준으로 파일 이름을 생성할 때 사용할 날짜 형식을 지정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
//      객체들을 저장할 리스트 생성
        List<TrimProcedureDTO> trimProcedureDTOS = new ArrayList<>();
//      TrimDTO 객체에서 trimProcedureDTOList 필드를 가져와서 TrimProcedureDTOList 객체들을 저장
        List<TrimProcedureDTO> trimProcedureDTOS1 = trimDTO.getTrimProcedureDTOList();
//      TrimDTO 객체에서 trimNum 필드를 가져와 손질 번호 저장
        int trimNum = TrimDTO.getTrimNum();
        MultipartFile file = trimDTO.

//      손질법 등록 확인
//        System.out.println("trimNum");
        System.out.println("trimTitle");
        System.out.println("trimDetail");
        System.out.println("trimViews");
        System.out.println("trimVideoLink");
        System.out.println(trimDTO); // 제목, 내용, 동영상URL ok, (번호 : 0 , 조회수 : 0, 상태 : null x)

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
}
