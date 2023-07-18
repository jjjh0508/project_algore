package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipePhotoDTO {

    private int photoNum;
    private String recipeFileName;
    private String recipePhotoPath;

    private MultipartFile photoInputFile;
    public RecipePhotoDTO() {
    }

    public RecipePhotoDTO(int photoNum, String recipeFileName, String recipePhotoPath, MultipartFile photoInputFile) {
        this.photoNum = photoNum;
        this.recipeFileName = recipeFileName;
        this.recipePhotoPath = recipePhotoPath;
        this.photoInputFile = photoInputFile;
    }

    public void setPhotoNum(int photoNum) {
        this.photoNum = photoNum;
    }

    public void setRecipeFileName(String recipeFileName) {
        this.recipeFileName = recipeFileName;
    }

    public void setRecipePhotoPath(String recipePhotoPath) {
        this.recipePhotoPath = recipePhotoPath;
    }

    public int getPhotoNum() {
        return photoNum;
    }

    public String getRecipeFileName() {
        return recipeFileName;
    }

    public String getRecipePhotoPath() {
        return recipePhotoPath;
    }

    public MultipartFile getPhotoInputFile() {
        return photoInputFile;
    }

    public void setPhotoInputFile(MultipartFile photoInputFile) {
        this.photoInputFile = photoInputFile;
    }

    @Override
    public String toString() {
        return "RecipePhotoDTO{" +
                "photoNum=" + photoNum +
                ", recipeFileName='" + recipeFileName + '\'' +
                ", recipePhotoPath='" + recipePhotoPath + '\'' +
                ", photoInputFile=" + photoInputFile +
                '}';
    }
}
