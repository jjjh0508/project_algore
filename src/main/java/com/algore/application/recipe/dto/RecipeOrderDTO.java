package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipeOrderDTO {
    private int rpNum;
    private int recipeNum;
    private String content;
    private String fileName;
    private String path;

    private MultipartFile oprderInputFile;
    public RecipeOrderDTO() {
    }

    public RecipeOrderDTO(int rpNum, int recipeNum, String content, String fileName, String path, MultipartFile oprderInputFile) {
        this.rpNum = rpNum;
        this.recipeNum = recipeNum;
        this.content = content;
        this.fileName = fileName;
        this.path = path;
        this.oprderInputFile = oprderInputFile;
    }

    public int getRpNum() {
        return rpNum;
    }

    public void setRpNum(int rpNum) {
        this.rpNum = rpNum;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
                ", recipeNum=" + recipeNum +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", oprderInputFile=" + oprderInputFile +
                '}';
    }
}
