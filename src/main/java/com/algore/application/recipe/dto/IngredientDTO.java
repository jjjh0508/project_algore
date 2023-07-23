package com.algore.application.recipe.dto;

public class IngredientDTO {
    private int ingNum; // 재료번호
    private String ingName; // 재료이름

    public IngredientDTO() {
    }

    public IngredientDTO(int ingNum, String ingName) {
        this.ingNum = ingNum;
        this.ingName = ingName;
    }

    public int getIngNum() {
        return ingNum;
    }

    public void setIngNum(int ingNum) {
        this.ingNum = ingNum;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "ingNum=" + ingNum +
                ", ingName='" + ingName + '\'' +
                '}';
    }
}
