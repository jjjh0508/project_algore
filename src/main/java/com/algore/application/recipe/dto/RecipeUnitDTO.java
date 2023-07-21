package com.algore.application.recipe.dto;

public class RecipeUnitDTO {

    private int riUnitNum; //재료 단위 번호
    private String riUnit; //재료 단위

    public RecipeUnitDTO() {
    }

    public RecipeUnitDTO(int riUnitNum, String riUnit) {
        this.riUnitNum = riUnitNum;
        this.riUnit = riUnit;
    }

    public int getRiUnitNum() {
        return riUnitNum;
    }

    public void setRiUnitNum(int riUnitNum) {
        this.riUnitNum = riUnitNum;
    }

    public String getRiUnit() {
        return riUnit;
    }

    public void setRiUnit(String riUnit) {
        this.riUnit = riUnit;
    }

    @Override
    public String toString() {
        return "RecipeUnitDTO{" +
                "riUnitNum=" + riUnitNum +
                ", riUnit='" + riUnit + '\'' +
                '}';
    }
}
