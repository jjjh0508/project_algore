package com.algore.application.recipe.dto;

public class SelectProcedure {

    private int recipeNum;
    private String rpContent;
    private String rpFileName;
    private String rpPath;

    public SelectProcedure() {
    }

    public SelectProcedure(int recipeNum, String rpContent, String rpFileName, String rpPath) {
        this.recipeNum = recipeNum;
        this.rpContent = rpContent;
        this.rpFileName = rpFileName;
        this.rpPath = rpPath;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public String getRpContent() {
        return rpContent;
    }

    public void setRpContent(String rpContent) {
        this.rpContent = rpContent;
    }

    public String getRpFileName() {
        return rpFileName;
    }

    public void setRpFileName(String rpFileName) {
        this.rpFileName = rpFileName;
    }

    public String getRpPath() {
        return rpPath;
    }

    public void setRpPath(String rpPath) {
        this.rpPath = rpPath;
    }

    @Override
    public String toString() {
        return "SelectProcedure{" +
                "recipeNum=" + recipeNum +
                ", rpContent='" + rpContent + '\'' +
                ", rpFileName='" + rpFileName + '\'' +
                ", rpPath='" + rpPath + '\'' +
                '}';
    }
}
