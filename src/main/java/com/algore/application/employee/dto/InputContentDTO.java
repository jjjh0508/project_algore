package com.algore.application.employee.dto;

import org.springframework.web.multipart.MultipartFile;

public class InputContentDTO {

    private String inputName;
    private String inputContent;
    private MultipartFile inputFile;

    public InputContentDTO() {
    }

    public InputContentDTO(String inputName, String inputContent, MultipartFile inputFile) {
        this.inputName = inputName;
        this.inputContent = inputContent;
        this.inputFile = inputFile;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputContent() {
        return inputContent;
    }

    public void setInputContent(String inputContent) {
        this.inputContent = inputContent;
    }

    public MultipartFile getInputFile() {
        return inputFile;
    }

    public void setInputFile(MultipartFile inputFile) {
        this.inputFile = inputFile;
    }

    @Override
    public String toString() {
        return "InputContentDTO{" +
                "inputName='" + inputName + '\'' +
                ", inputContent='" + inputContent + '\'' +
                ", inputFile=" + inputFile +
                '}';
    }
}
