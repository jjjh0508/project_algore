package com.algore.application.employee.controller;

import com.algore.application.employee.dto.InputContentDTO;
import com.algore.application.employee.dto.InsertEmpDTO;
import com.algore.application.employee.dto.SelectEmployeeDTO;
import com.algore.application.employee.dto.TestDTO;
import com.algore.application.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/employee")
public class EmployeeCotroller {

    private final EmployeeService employeeService;

    /*application.yml 파일에 정의되어 있는 key를 가져온다.*/
    @Value("${open-api.key}")
    private String apiKey;

    public EmployeeCotroller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ModelAndView selectAll(ModelAndView mv){

        List<SelectEmployeeDTO> empList = employeeService.selectAll();

        mv.addObject("empList", empList);
        mv.setViewName("employee/list");
        return mv;

    }

    @GetMapping("/regist")
    public String regist(){
        return "employee/insert";
    }

    @PostMapping(value = "/regist")
    public ModelAndView registEmp(ModelAndView model, InsertEmpDTO insertEmpDTO){
        // 유효성 체크 해야됨

        int result = employeeService.registEmployee(insertEmpDTO);

        String path = "";
        if(result > 0){
            model.addObject("message", "등록이 완료되었습니다.");
            model.setViewName("redirect:/employee/list");
        }else{
            model.addObject("message", "등록에 실패하였습니다.");
            model.setViewName("redirect:/");
        }

        return model;
    }

    @GetMapping("/file")
    public void goFile(){
    }

    /* @ModelAttribute : 컨트롤러 메소드의 매개변수에 사용되는 어노테이션
    *                    어노테이션이 적용된 매개변수는 해당 요청의 모델 속성(attribute) 처리
    *                    일반적으로 클라이언트가 요청한 데이터를 받아와서 모델 객체에 매핑하기 위해서 사용
    *                    (insertFile 메소드는 inputContent 객체를 사용해서 클라이언트로부터 전달된 데이터 매핑해서 처리)
    * HttpServletRequest : 현재 요청에 대한 정보를 담고 있는 HttpServletRequest 객체,
    *                      클라이언트의 요청 정보를 확인하거나 추가적인 작업을 수행할 수 있다
    * */
    @PostMapping("/file")
    public ModelAndView insertFile(@ModelAttribute InputContentDTO inputContent, HttpServletRequest request /* @RequestParam MultipartFile파일 전송 객체 file*/){
        /* 설명
        * 파일을 입력 받고 해당 파일을 로컬에 저장한 뒤 저장된 경로를 데이터 베이스에 저장한 다음 해당 포스팅을 불러올때 이미지 경로에 경로를 넣어준다.
        * */
        ModelAndView modelAndView = new ModelAndView();
        // 사용자의 이전 요청 값을 확인한다
        /* Referer : 클라이언트가 현재 요청을 보내기 전에 위치한 이전 페이지 URL을 나타냄 (이전 페이지로부터 현재 페이지로 이동하기 위해 해당 요청 발생)
         * HttpServletRequest 객체에서 "Referer" 헤더 값을 가져와서 backUrl 변수에 저장
         * 아래 코드는 이전 페이지의 URL을 추적하거나 이전 페이지로 redirect 등과 같은 작업 수행 ok*/
        String backUrl = request.getHeader("Referer");

        //파일의 확장자를 가져온다.
        /* inputContent 객체에서 getInputFile()를 호출하여 MultipartFile 타입의 fileOne 변수에 파일 데이터를 할당하는 코드
        *  MultipartFile은 업로드된 파일을 나타내는 스프링 프레임워크의 인터페이스 */
        MultipartFile fileOne = inputContent.getInputFile();
        /* fileOne 객체의 getOriginalFilename()를 호출하여 업로드된 파일의 원래 파일 이름을 가져온 뒤 해당 파일 이름에서
        *  파일 확장자를 추출하여 ext 변수에 할당하는 코드
        *  getOriginalFilename() : 업로드된 파일의 원래 파일 이름 반환
        *  substring() : 문자열에서 특정 위치부터 끝까지의 부분 문자열 추출
        *  indexOf() : 파일 이름에서 마지막 점('.')의 인덱스를 찾은 뒤 해당 인덱스부터 끝까지의 문자열을 추출하여 파일 확장자 얻음
        *              ex) 파일 이름 'example.jpg'일 경우 ext 변수에는 .jpg 할당*/
        String ext =  fileOne.getOriginalFilename().substring(fileOne.getOriginalFilename().indexOf("."));

        // 파일 확장자가 이미지 확장자가 아닌경우
        if(!(ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg"))){
            modelAndView.addObject("message",  "이미지가 아니네용");
            modelAndView.setViewName(backUrl);

            return modelAndView;
        }


//        System.out.println(inputContent.getInputFile().getOriginalFilename()); // 파일의 오리지날 값을 읽어온다.


        if(inputContent.getInputFile() != null){ // 업로드된 파일이 존재하는 경우
            /* originFilePath 변수에 upload\basic 경로 할당 -> 원본 파일이 저장될 폴더의 상대 경로 */
            String originFilePath = "\\upload\\basic\\";
            /* path 변수에 프로그램 내부 경로를 나타내는
            *  System.getProperty("user.dir")와 "\\src\\main\\resources\\static" 경로를 조합한 뒤
            *  originFilePath를 추가하여 최종 파일 저장 경로를 생성*/
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static" + originFilePath; // 프로그램 내부 경로
            /* path로부터 생성한 파일 객체를 originDirectory를 생성*/
            File originDirectory = new File(path);
            /* originDirectory가 존재하지 않는 경우*/
            if(!originDirectory.exists()){ //해당 경로의 폴더가 없는 경우
                /* 해당 경로의 폴더 생성 즉, 폴더가 존재하지 않는 경우에만 폴더 생성*/
                originDirectory.mkdirs(); // 해당 폴더를 만들어라
            }
            // 파일명 변경

            // 파일 저장경로에 파일 이름을 추가한다.
            /* 즉 최종 파일 저장 경로에 업로드된 파일의 원래 파일 이름을 포함*/
            path += inputContent.getInputFile().getOriginalFilename();


            //파일 저장
            try {
                /* 업로드된 파일을 최종 파일 저장 경로에 저장*/
                inputContent.getInputFile().transferTo(new File(path));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            /* modelAndView 객체에 파일 저장 성공이라는 메시지 추가*/
            modelAndView.addObject("message", "파일 저장 성공");
        /* inputContent.getInputFile()이 null인 경우 -> 업로드된 파일이 존재하지 않는 경우 */
        }else{
            /* modelAndView 객체에 파일 저장 실패라는 메시지 추가*/
            modelAndView.addObject("message", "파일 저장 실패");
            /* 처리가 완료되면 modelAndView 객체를 반환하고 메소드 실행 종료*/
            return modelAndView;
        }
        /* modelAndView 뷰 이름을 index로 설정*/
        modelAndView.setViewName("index");
        /* 처리가 완료되었으므로 modelAndView 객체 반환
        *  해당 조건에 맞는 동작 수행되고 index 뷰로 이동*/
        return modelAndView;
    }


    // DTO 타입의 obj전달시 아래와 같이 ModelAttribute를 사용할 수 있다.
    @PostMapping("/namecontroller")
    public String nameList(@ModelAttribute TestDTO testList){

        if(Objects.isNull(testList)){
            return "insert";
        }else{
            for (String name: testList.getName()) {
                System.out.println(name);
            }
            for (int test: testList.getTest()) {
                System.out.println(test);
            }
        }

        return "redirect:/";
    }

}
