package com.algore.application.recipe.dto;

public class RecipeWriteDTO {

    private String nickName; //닉네임
    private String mainPhoto; //메인사진 파일명
    private String photoPath; //메인사진 저장경로
    private String category; //카테고리명
    private String recipeTitle; //레시피 제목
    private String recipeIntro; //요리 소개
    private String recipeVideoLink; //동영상 링크
    private String ingName; //재료 이름
    private String weigh; //계량
    private String riUnit; //래시피 단위명
    private String rpFileName; //레시피 요리순서 파일명
    private String rpPath; //레시피 요리순서 저장경로
    private String rpContent; //레시피 요리순서 내용
    private String tip; //레시피 팁
    private String recipeFileName; //레시피 완성사진 파일명
    private String recipePath; //레시피 완성사진 저장경로

    public RecipeWriteDTO() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getRecipeIntro() {
        return recipeIntro;
    }

    public void setRecipeIntro(String recipeIntro) {
        this.recipeIntro = recipeIntro;
    }

    public String getRecipeVideoLink() {
        return recipeVideoLink;
    }

    public void setRecipeVideoLink(String recipeVideoLink) {
        this.recipeVideoLink = recipeVideoLink;
    }

    public String getIngName() {
        return ingName;
    }

    public void setIngName(String ingName) {
        this.ingName = ingName;
    }

    public String getWeigh() {
        return weigh;
    }

    public void setWeigh(String weigh) {
        this.weigh = weigh;
    }

    public String getRiUnit() {
        return riUnit;
    }

    public void setRiUnit(String riUnit) {
        this.riUnit = riUnit;
    }

    public String getRpFileName() {
        return rpFileName;
    }

    public void setRpFileName(String rpFileName) {
        this.rpFileName = rpFileName;
    }

    public String getRpPath() {
        return rpPath;
    }

    public void setRpPath(String rpPath) {
        this.rpPath = rpPath;
    }

    public String getRpContent() {
        return rpContent;
    }

    public void setRpContent(String rpContent) {
        this.rpContent = rpContent;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getRecipeFileName() {
        return recipeFileName;
    }

    public void setRecipeFileName(String recipeFileName) {
        this.recipeFileName = recipeFileName;
    }

    public String getRecipePath() {
        return recipePath;
    }

    public void setRecipePath(String recipePath) {
        this.recipePath = recipePath;
    }

    @Override
    public String toString() {
        return "RecipeWriteDTO{" +
                "nickName='" + nickName + '\'' +
                ", mainPhoto='" + mainPhoto + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", category='" + category + '\'' +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeIntro='" + recipeIntro + '\'' +
                ", recipeVideoLink='" + recipeVideoLink + '\'' +
                ", ingName='" + ingName + '\'' +
                ", weigh='" + weigh + '\'' +
                ", riUnit='" + riUnit + '\'' +
                ", rpFileName='" + rpFileName + '\'' +
                ", rpPath='" + rpPath + '\'' +
                ", rpContent='" + rpContent + '\'' +
                ", tip='" + tip + '\'' +
                ", recipeFileName='" + recipeFileName + '\'' +
                ", recipePath='" + recipePath + '\'' +
                '}';
    }
}
