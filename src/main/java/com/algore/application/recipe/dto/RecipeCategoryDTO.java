package com.algore.application.recipe.dto;

public class RecipeCategoryDTO {

    private int categoryNum; // 카테고리번호
    private String category; // 카테고리명

    public RecipeCategoryDTO() {
    }

    public RecipeCategoryDTO(int categoryNum, String category) {
        this.categoryNum = categoryNum;
        this.category = category;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(int categoryNum) {
        this.categoryNum = categoryNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "RecipeCategoryDTO{" +
                "categoryNum=" + categoryNum +
                ", category='" + category + '\'' +
                '}';
    }
}
