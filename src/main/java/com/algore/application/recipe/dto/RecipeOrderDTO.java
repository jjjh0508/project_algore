package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipeOrderDTO {
    private int rpNum;
    private int recipe_num;
    private String content;
    private String fileName;
    private String path;

    private MultipartFile oprderInputFile;
    public RecipeOrderDTO() {
    }

    public RecipeOrderDTO(int rpNum, int recipe_num, String content, String fileName, String path, MultipartFile oprderInputFile) {
        this.rpNum = rpNum;
        this.recipe_num = recipe_num;
        this.content = content;
        this.fileName = fileName;
        this.path = path;
        this.oprderInputFile = oprderInputFile;
    }

    public int getRpNum() {
        return rpNum;
    }

    public String getContent() {
        return content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPrNum(int rpNum) {
        this.rpNum = rpNum;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRecipe_num() {
        return recipe_num;
    }

    public void setRecipe_num(int recipe_num) {
        this.recipe_num = recipe_num;
    }

    public void setRpNum(int rpNum) {
        this.rpNum = rpNum;
    }

    public MultipartFile getOprderInputFile() {
        return oprderInputFile;
    }

    public void setOprderInputFile(MultipartFile oprderInputFile) {
        this.oprderInputFile = oprderInputFile;
    }

    @Override
    public String toString() {
        return "RecipeOrderDTO{" +
                "rpNum=" + rpNum +
                ", recipe_num=" + recipe_num +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", oprderInputFile=" + oprderInputFile +
                '}';
    }
}
