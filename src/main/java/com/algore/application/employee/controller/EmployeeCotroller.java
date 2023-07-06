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


    @PostMapping("/file")
    public ModelAndView insertFile(@ModelAttribute InputContentDTO inputContent, HttpServletRequest request
            /*@RequestParam MultipartFile파일 전송 객체 file*/){
        /* 설명
        * 파일을 입력 받고 해당 파일을 로컬에 저장한 뒤 저장된 경로를 데이터 베이스에 저장한 다음 해당 포스팅을 불러올때 이미지 경로에 경로를 넣어준다.
        * */
        ModelAndView modelAndView = new ModelAndView();
        // 사용자의 이전 요청 값을 확인한다
        String backUrl = request.getHeader("Refere");

        //파일의 확장자를 가져온다.
        MultipartFile fileOne = inputContent.getInputFile();
        String ext =  fileOne.getOriginalFilename().substring(fileOne.getOriginalFilename().indexOf("."));

        if(!(ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg"))){ // 파일 확장자가 이미지 확장자가 아닌경우
            modelAndView.addObject("message",  "이미지가 아니네용");
            modelAndView.setViewName(backUrl);

            return modelAndView;
        }


//        System.out.println(inputContent.getInputFile().getOriginalFilename()); // 파일의 오리지날 값을 읽어온다.


        if(inputContent.getInputFile() != null){
            String originFilePath = "\\upload\\basic\\";
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static" + originFilePath; // 프로그램 내부 경로

            File originDirectory = new File(path);

            if(!originDirectory.exists()){ //해당 경로의 폴더가 없는 경우
                originDirectory.mkdirs(); // 해당 폴더를 만들어라
            }
            // 파일명 변경

            // 파일 저장경로에 파일 이름을 추가한다.
            path += inputContent.getInputFile().getOriginalFilename();


            //파일 저장
            try {
                inputContent.getInputFile().transferTo(new File(path));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            modelAndView.addObject("message", "파일 저장 성공");
        }else{
            modelAndView.addObject("message", "파일 저장 실패");
            return modelAndView;
        }
        modelAndView.setViewName("index");

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
