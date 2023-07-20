package com.algore.application.recipe.dto;

public class RecipeIngredientDTO {

    private int ingNum; // 재료 번호
    private int recipeNum; //레시피 번호
    private int weigh; // 계량
    private String riUnit; // 레시피 단위명

    private int riUnitNum; //단위 번호

    private String category; // 카테고리

    private String ingName; //이름

    private int price; // 가격

    private int allPrice; // 전체가격
    public RecipeIngredientDTO() {
    }

    public RecipeIngredientDTO(int ingNum, int recipeNum, int weigh, String riUnit, int riUnitNum, String category, String ingName, int price, int allPrice) {
        this.ingNum = ingNum;
        this.recipeNum = recipeNum;
        this.weigh = weigh;
        this.riUnit = riUnit;
        this.riUnitNum = riUnitNum;
        this.category = category;
        this.ingName = ingName;
        this.price = price;
        this.allPrice = allPrice;
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

    public int getRiUnitNum() {
        return riUnitNum;
    }

    public void setRiUnitNum(int riUnitNum) {
        this.riUnitNum = riUnitNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    @Override
    public String toString() {
        return "RecipeIngredientDTO{" +
                "ingNum=" + ingNum +
                ", recipeNum=" + recipeNum +
                ", weigh=" + weigh +
                ", riUnit='" + riUnit + '\'' +
                ", riUnitNum=" + riUnitNum +
                ", category='" + category + '\'' +
                ", ingName='" + ingName + '\'' +
                ", price=" + price +
                ", allPrice=" + allPrice +
                '}';
    }
}
