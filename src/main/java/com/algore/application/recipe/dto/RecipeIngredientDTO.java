package com.algore.application.recipe.dto;

public class RecipeIngredientDTO {

    private int ingNum; // 재료 번호
    private int recipeNum; //레시피 번호
    private int weigh; // 계량
    private String riUnit; // 레시피 단위명

    public RecipeIngredientDTO() {
    }

    public RecipeIngredientDTO(int ingNum, int recipeNum, int weigh, String riUnit) {
        this.ingNum = ingNum;
        this.recipeNum = recipeNum;
        this.weigh = weigh;
        this.riUnit = riUnit;
    }

    public int getIngNum() {
        return ingNum;
    }

    public void setIngNum(int ingNum) {
        this.ingNum = ingNum;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    public String getRiUnit() {
        return riUnit;
    }

    public void setRiUnit(String riUnit) {
        this.riUnit = riUnit;
    }

    @Override
    public String toString() {
        return "RecipeIngredientDTO{" +
                "ingNum=" + ingNum +
                ", recipeNum=" + recipeNum +
                ", weigh=" + weigh +
                ", riUnit='" + riUnit + '\'' +
                '}';
    }
}
