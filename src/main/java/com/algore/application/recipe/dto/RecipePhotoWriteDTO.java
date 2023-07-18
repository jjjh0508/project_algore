package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

public class RecipePhotoWriteDTO {

    private int photoNum;
    private String recipeFileName;
    private MultipartFile recipePhotoPath;

    public RecipePhotoWriteDTO() {
    }

    public RecipePhotoWriteDTO(int photoNum, String recipeFileName, MultipartFile recipePhotoPath) {
        this.photoNum = photoNum;
        this.recipeFileName = recipeFileName;
        this.recipePhotoPath = recipePhotoPath;
    }

    public int getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(int photoNum) {
        this.photoNum = photoNum;
    }

    public String getRecipeFileName() {
        return recipeFileName;
    }

    public void setRecipeFileName(String recipeFileName) {
        this.recipeFileName = recipeFileName;
    }

    public MultipartFile getRecipePhotoPath() {
        return recipePhotoPath;
    }

    public void setRecipePhotoPath(MultipartFile recipePhotoPath) {
        this.recipePhotoPath = recipePhotoPath;
    }

    @Override
    public String toString() {
        return "RecipePhotoWriteDTO{" +
                "photoNum=" + photoNum +
                ", recipeFileName='" + recipeFileName + '\'' +
                ", recipePhotoPath=" + recipePhotoPath +
                '}';
    }
}
