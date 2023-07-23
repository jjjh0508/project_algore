package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipePhotoWriteDTO {

    private int photoNumber; // 사진번호
    private int recipeNum; // 레시피 번호
    private String recipeFileName; // 파일명
    private String recipePhotoPath; // 저장경로
    private MultipartFile recipePhotoWriteInput; // 파일

    public RecipePhotoWriteDTO() {
    }

    public RecipePhotoWriteDTO(int photoNumber, int recipeNum, String recipeFileName, String recipePhotoPath, MultipartFile recipePhotoWriteInput) {
        this.photoNumber = photoNumber;
        this.recipeNum = recipeNum;
        this.recipeFileName = recipeFileName;
        this.recipePhotoPath = recipePhotoPath;
        this.recipePhotoWriteInput = recipePhotoWriteInput;
    }

    public int getPhotoNumber() {
        return photoNumber;
    }

    public void setPhotoNumber(int photoNumber) {
        this.photoNumber = photoNumber;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public String getRecipeFileName() {
        return recipeFileName;
    }

    public void setRecipeFileName(String recipeFileName) {
        this.recipeFileName = recipeFileName;
    }

    public String getRecipePhotoPath() {
        return recipePhotoPath;
    }

    public void setRecipePhotoPath(String recipePhotoPath) {
        this.recipePhotoPath = recipePhotoPath;
    }

    public MultipartFile getRecipePhotoWriteInput() {
        return recipePhotoWriteInput;
    }

    public void setRecipePhotoWriteInput(MultipartFile recipePhotoWriteInput) {
        this.recipePhotoWriteInput = recipePhotoWriteInput;
    }

    @Override
    public String toString() {
        return "RecipePhotoWriteDTO{" +
                "photoNumber=" + photoNumber +
                ", recipeNum=" + recipeNum +
                ", recipeFileName='" + recipeFileName + '\'' +
                ", recipePhotoPath='" + recipePhotoPath + '\'' +
                ", recipePhotoWriteInput=" + recipePhotoWriteInput +
                '}';
    }
}
