package com.algore.application.recipe.dto;

public class CommentInsertDTO {
    private int recipeNum;
    private String conutent;

    private String userId;


    public CommentInsertDTO() {
    }

    public CommentInsertDTO(int recipeNum, String conutent, String userId) {
        this.recipeNum = recipeNum;
        this.conutent = conutent;
        this.userId = userId;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public String getConutent() {
        return conutent;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public void setConutent(String conutent) {
        this.conutent = conutent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CommentInsertDTO{" +
                "recipeNum=" + recipeNum +
                ", conutent='" + conutent + '\'' +
                ", id='" + userId + '\'' +
                '}';
    }
}

