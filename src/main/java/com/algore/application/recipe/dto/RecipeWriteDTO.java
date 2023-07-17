package com.algore.application.recipe.dto;

public class RecipeWriteDTO {

    private String memName; //닉네임
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

    public RecipeWriteDTO(String memName, String mainPhoto, String photoPath, String category, String recipeTitle, String recipeIntro, String recipeVideoLink, String ingName, String weigh, String riUnit, String rpFileName, String rpPath, String rpContent, String tip, String recipeFileName, String recipePath) {
        this.memName = memName;
        this.mainPhoto = mainPhoto;
        this.photoPath = photoPath;
        this.category = category;
        this.recipeTitle = recipeTitle;
        this.recipeIntro = recipeIntro;
        this.recipeVideoLink = recipeVideoLink;
        this.ingName = ingName;
        this.weigh = weigh;
        this.riUnit = riUnit;
        this.rpFileName = rpFileName;
        this.rpPath = rpPath;
        this.rpContent = rpContent;
        this.tip = tip;
        this.recipeFileName = recipeFileName;
        this.recipePath = recipePath;
    }



}
