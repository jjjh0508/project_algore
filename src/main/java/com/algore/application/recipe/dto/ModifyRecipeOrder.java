package com.algore.application.recipe.dto;

public class ModifyRecipeOrder {
    private int recipeNum;
    private String content;
    private String fileName;
    private String path;

    public ModifyRecipeOrder() {
    }

    public ModifyRecipeOrder(int recipeNum, String content, String fileName, String path) {
        this.recipeNum = recipeNum;
        this.content = content;
        this.fileName = fileName;
        this.path = path;
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

    @Override
    public String toString() {
        return "ModifyRecipeOrder{" +
                "recipeNum=" + recipeNum +
                ", content='" + content + '\'' +
                ", fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
