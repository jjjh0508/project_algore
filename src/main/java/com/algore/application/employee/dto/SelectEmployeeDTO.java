package com.algore.application.employee.dto;

public class SelectEmployeeDTO {

    private String empId;
    private String empName;
    private String empNo;
    private String email;

    public SelectEmployeeDTO() {
    }

    public SelectEmployeeDTO(String empId, String empName, String empNo, String email) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
