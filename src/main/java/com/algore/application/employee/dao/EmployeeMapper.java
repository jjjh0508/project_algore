package com.algore.application.employee.dao;

import com.algore.application.employee.dto.InsertEmpDTO;
import com.algore.application.employee.dto.SelectEmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<SelectEmployeeDTO> selectAll();

    int registEmployee(InsertEmpDTO insertEmpDTO);
}
