package com.algore.application.recipe.dto;

public class RecipeProcedureDTO {

    private int rpNum; // 단계 번호
    private int recipeNum; // 레시피 번호
    private String rpFileName; // 파일명
    private String rpPath; // 저장경로
    private String rpContent; // 내용

    public RecipeProcedureDTO() {
    }

    public RecipeProcedureDTO(int rpNum, int recipeNum, String rpFileName, String rpPath, String rpContent) {
        this.rpNum = rpNum;
        this.recipeNum = recipeNum;
        this.rpFileName = rpFileName;
        this.rpPath = rpPath;
        this.rpContent = rpContent;
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

    public String getRpContent() {
        return rpContent;
    }

    public void setRpContent(String rpContent) {
        this.rpContent = rpContent;
    }

    @Override
    public String toString() {
        return "RecipeProcedureDTO{" +
                "rpNum=" + rpNum +
                ", recipeNum=" + recipeNum +
                ", rpFileName='" + rpFileName + '\'' +
                ", rpPath='" + rpPath + '\'' +
                ", rpContent='" + rpContent + '\'' +
                '}';
    }
}
