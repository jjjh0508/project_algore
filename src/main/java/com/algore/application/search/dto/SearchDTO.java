package com.algore.application.search.dto;

public class SearchDTO {
    private String recipeTitle;
    private int views;
    private String fileName;
    private String filePath;

    private int recipeNum;

    public SearchDTO() {
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public SearchDTO(String recipeTitle, int views, String fileName, String filePath, int recipeNum) {
        this.recipeTitle = recipeTitle;
        this.views = views;
        this.fileName = fileName;
        this.filePath = filePath;
        this.recipeNum = recipeNum;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    @Override
    public String toString() {
        return "MainViewDTO{" +
                "recipeTitle='" + recipeTitle + '\'' +
                ", views=" + views +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", recipeNum=" + recipeNum +
                '}';
    }
}
