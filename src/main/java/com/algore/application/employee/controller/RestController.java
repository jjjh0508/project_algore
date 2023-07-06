package com.algore.application.employee.controller;

import com.algore.application.employee.dto.SelectEmployeeDTO;
import com.algore.application.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final EmployeeService employeeService;

    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public List<SelectEmployeeDTO> empAll(){
        List<SelectEmployeeDTO> allEmp = employeeService.selectAll();
        if (Objects.isNull(allEmp)) {
            return null;
        }else{
            return allEmp;
        }
    }
}
