package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class RecipeWriteDTO {

    private int recipeNum; //레시피 번호
    private int memNum; //회원 번호
    private String mainPhoto; //메인 사진 파일명
    private MultipartFile mainPhotoInputFile; // 메인 사진
    private String photoPath; // 저장경로
    private List<RecipeCategoryDTO> recipeCategoryDTOList; // 레시피 카테고리
    private String recipeTitle; //레시피 제목
    private String recipeIntro; // 요리 소개
    private String recipeVideoLink; // 동영상 링크
    private String tip; // 요리 팁
    private Date recipeCreateDate; // 작성 날짜
    private List<RecipeIngredientDTO> recipeIngredientDTOList; // 레시피 재료
    private List<IngredientDTO> ingredientDTOList; // 재료
    private List<RecipeProcedureDTO> recipeProcedureDTOList; // 레시피 단계
    private List<RecipePhotoWriteDTO> recipePhotoWriteDTOList; // 레시피 완성사진

    public RecipeWriteDTO() {
    }

    public RecipeWriteDTO(int recipeNum, int memNum, String mainPhoto, MultipartFile mainPhotoInputFile, String photoPath, List<RecipeCategoryDTO> recipeCategoryDTOList, String recipeTitle, String recipeIntro, String recipeVideoLink, String tip, Date recipeCreateDate, List<RecipeIngredientDTO> recipeIngredientDTOList, List<IngredientDTO> ingredientDTOList, List<RecipeProcedureDTO> recipeProcedureDTOList, List<RecipePhotoWriteDTO> recipePhotoWriteDTOList) {
        this.recipeNum = recipeNum;
        this.memNum = memNum;
        this.mainPhoto = mainPhoto;
        this.mainPhotoInputFile = mainPhotoInputFile;
        this.photoPath = photoPath;
        this.recipeCategoryDTOList = recipeCategoryDTOList;
        this.recipeTitle = recipeTitle;
        this.recipeIntro = recipeIntro;
        this.recipeVideoLink = recipeVideoLink;
        this.tip = tip;
        this.recipeCreateDate = recipeCreateDate;
        this.recipeIngredientDTOList = recipeIngredientDTOList;
        this.ingredientDTOList = ingredientDTOList;
        this.recipeProcedureDTOList = recipeProcedureDTOList;
        this.recipePhotoWriteDTOList = recipePhotoWriteDTOList;
    }

    public int getRecipeNum() {
        return recipeNum;
    }

    public void setRecipeNum(int recipeNum) {
        this.recipeNum = recipeNum;
    }

    public int getMemNum() {
        return memNum;
    }

    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public MultipartFile getMainPhotoInputFile() {
        return mainPhotoInputFile;
    }

    public void setMainPhotoInputFile(MultipartFile mainPhotoInputFile) {
        this.mainPhotoInputFile = mainPhotoInputFile;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public List<RecipeCategoryDTO> getRecipeCategoryDTOList() {
        return recipeCategoryDTOList;
    }

    public void setRecipeCategoryDTOList(List<RecipeCategoryDTO> recipeCategoryDTOList) {
        this.recipeCategoryDTOList = recipeCategoryDTOList;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getRecipeCreateDate() {
        return recipeCreateDate;
    }

    public void setRecipeCreateDate(Date recipeCreateDate) {
        this.recipeCreateDate = recipeCreateDate;
    }

    public List<RecipeIngredientDTO> getRecipeIngredientDTOList() {
        return recipeIngredientDTOList;
    }

    public void setRecipeIngredientDTOList(List<RecipeIngredientDTO> recipeIngredientDTOList) {
        this.recipeIngredientDTOList = recipeIngredientDTOList;
    }

    public List<IngredientDTO> getIngredientDTOList() {
        return ingredientDTOList;
    }

    public void setIngredientDTOList(List<IngredientDTO> ingredientDTOList) {
        this.ingredientDTOList = ingredientDTOList;
    }

    public List<RecipeProcedureDTO> getRecipeProcedureDTOList() {
        return recipeProcedureDTOList;
    }

    public void setRecipeProcedureDTOList(List<RecipeProcedureDTO> recipeProcedureDTOList) {
        this.recipeProcedureDTOList = recipeProcedureDTOList;
    }

    public List<RecipePhotoWriteDTO> getRecipePhotoWriteDTOList() {
        return recipePhotoWriteDTOList;
    }

    public void setRecipePhotoWriteDTOList(List<RecipePhotoWriteDTO> recipePhotoWriteDTOList) {
        this.recipePhotoWriteDTOList = recipePhotoWriteDTOList;
    }

    @Override
    public String toString() {
        return "RecipeWriteDTO{" +
                "recipeNum=" + recipeNum +
                ", memNum=" + memNum +
                ", mainPhoto='" + mainPhoto + '\'' +
                ", mainPhotoInputFile=" + mainPhotoInputFile +
                ", photoPath='" + photoPath + '\'' +
                ", recipeCategoryDTOList=" + recipeCategoryDTOList +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeIntro='" + recipeIntro + '\'' +
                ", recipeVideoLink='" + recipeVideoLink + '\'' +
                ", tip='" + tip + '\'' +
                ", recipeCreateDate=" + recipeCreateDate +
                ", recipeIngredientDTOList=" + recipeIngredientDTOList +
                ", ingredientDTOList=" + ingredientDTOList +
                ", recipeProcedureDTOList=" + recipeProcedureDTOList +
                ", recipePhotoWriteDTOList=" + recipePhotoWriteDTOList +
                '}';
    }
}
