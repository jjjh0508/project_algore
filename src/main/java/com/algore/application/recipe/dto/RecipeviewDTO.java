package com.algore.application.recipe.dto;

import java.sql.Date;

public class RecipeviewDTO {
    private int recipeNum;
    private String memName;
    private String  category;
    private String recipeTitle;
    private String recipeViews;

    private Date recipeCreateDate;

    private String recipeIntro;

    private String tip;

    private String youtube= "https://www.youtube.com/embed/O-D7g3ajzRM";



    public RecipeviewDTO() {
    }

    public RecipeviewDTO(int recipeNum, String memName, String category, String recipeTitle, String recipeViews, Date recipeCreateDate, String recipeIntro, String tip) {
        this.recipeNum = recipeNum;
        this.memName = memName;
        this.category = category;
        this.recipeTitle = recipeTitle;
        this.recipeViews = recipeViews;
        this.recipeCreateDate = recipeCreateDate;
        this.recipeIntro = recipeIntro;
        this.tip = tip;
    }


    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public void setRecipeViews(String recipeViews) {
        this.recipeViews = recipeViews;
    }

    public void setRecipeCreateDate(Date recipeCreateDate) {
        this.recipeCreateDate = recipeCreateDate;
    }

    public void setRecipeIntro(String recipeIntro) {
        this.recipeIntro = recipeIntro;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public String getMemName() {
        return memName;
    }

    public String getCategory() {
        return category;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeViews() {
        return recipeViews;
    }

    public Date getRecipeCreateDate() {
        return recipeCreateDate;
    }

    public String getRecipeIntro() {
        return recipeIntro;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTip() {
        return tip;
    }
    @Override
    public String toString() {
        return "RecipeviewDTO{" +
                "recipeNum=" + recipeNum +
                ", memName='" + memName + '\'' +
                ", category='" + category + '\'' +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeViews='" + recipeViews + '\'' +
                ", recipeCreateDate=" + recipeCreateDate +
                ", recipeIntro='" + recipeIntro + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }

}
