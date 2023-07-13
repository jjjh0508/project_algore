package com.algore.application.recipe.dto;

public class RecipePhotoDTO {

    private int photoNum;
    private String recipeFileName;
    private String recipePhotoPath;

    public RecipePhotoDTO() {
    }

    public RecipePhotoDTO(int photoNum, String recipeFileName, String recipePhotoPath) {
        this.photoNum = photoNum;
        this.recipeFileName = recipeFileName;
        this.recipePhotoPath = recipePhotoPath;
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

    @Override
    public String toString() {
        return "RecipePhotoDTO{" +
                "photoNum=" + photoNum +
                ", recipeFileName='" + recipeFileName + '\'' +
                ", recipePhotoPath='" + recipePhotoPath + '\'' +
                '}';
    }
}
