package com.algore.application.employee.dto;

public class ModifyDTO {
    private int empNo;
    private String empName;
    private String entYn;

    public ModifyDTO() {
    }

    public ModifyDTO(int empNo, String empName, String entYn) {
        this.empNo = empNo;
        this.empName = empName;
        this.entYn = entYn;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEntYn() {
        return entYn;
    }

    public void setEntYn(String entYn) {
        this.entYn = entYn;
    }

    @Override
    public String toString() {
        return "ModifyDTO{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", entYn='" + entYn + '\'' +
                '}';
    }
}
