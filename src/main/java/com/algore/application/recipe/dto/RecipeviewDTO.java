package com.algore.application.recipe.dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

public class RecipeviewDTO {
    private int recipeNum;
    private String memName;
    private String  category;
    private String recipeTitle;
    private String recipeViews;

    private Date recipeCreateDate;

    private String recipeIntro;

    private String tip;

    private String youtube;

    private String mainFileName;
    private String mainPath;

    private String proFileName;
    private String proFilePath;
    private String recipeWriter;

    private MultipartFile mainInputFile;
    private List<RecipePhotoDTO> recipePhotoDTOList;
    private List<RecipeOrderDTO> recipeOrderList;

    public RecipeviewDTO() {
    }

    public RecipeviewDTO(int recipeNum, String memName, String category, String recipeTitle, String recipeViews, Date recipeCreateDate, String recipeIntro, String tip, String youtube, String mainFileName, String mainPath, String proFileName, String proFilePath, String recipeWriter, MultipartFile mainInputFile, List<RecipePhotoDTO> recipePhotoDTOList, List<RecipeOrderDTO> recipeOrderList) {
        this.recipeNum = recipeNum;
        this.memName = memName;
        this.category = category;
        this.recipeTitle = recipeTitle;
        this.recipeViews = recipeViews;
        this.recipeCreateDate = recipeCreateDate;
        this.recipeIntro = recipeIntro;
        this.tip = tip;
        this.youtube = youtube;
        this.mainFileName = mainFileName;
        this.mainPath = mainPath;
        this.proFileName = proFileName;
        this.proFilePath = proFilePath;
        this.recipeWriter = recipeWriter;
        this.mainInputFile = mainInputFile;
        this.recipePhotoDTOList = recipePhotoDTOList;
        this.recipeOrderList = recipeOrderList;
    }

    public List<RecipePhotoDTO> getRecipePhotoDTOList() {
        return recipePhotoDTOList;
    }

    public void setRecipePhotoDTOList(List<RecipePhotoDTO> recipePhotoDTOList) {
        this.recipePhotoDTOList = recipePhotoDTOList;
    }

    public List<RecipeOrderDTO> getRecipeOrderList() {
        return recipeOrderList;
    }

    public void setRecipeOrderList(List<RecipeOrderDTO> recipeOrderList) {
        this.recipeOrderList = recipeOrderList;
    }

    public void setProFileName(String proFileName) {
        this.proFileName = proFileName;
    }

    public void setProFilePath(String proFilePath) {
        this.proFilePath = proFilePath;
    }

    public String getProFileName() {
        return proFileName;
    }

    public String getProFilePath() {
        return proFilePath;
    }

    public String getMainFileName() {
        return mainFileName;
    }

    public String getMainPath() {
        return mainPath;
    }

    public void setMainFileName(String mainFileName) {
        this.mainFileName = mainFileName;
    }

    public void setMainPath(String mainPath) {
        this.mainPath = mainPath;
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

    public MultipartFile getMainInputFile() {
        return mainInputFile;
    }

    public void setMainInputFile(MultipartFile mainInputFile) {
        this.mainInputFile = mainInputFile;
    }

    public void setRecipeWriter(String recipeWriter) {
        this.recipeWriter = recipeWriter;
    }

    public String getRecipeWriter() {
        return recipeWriter;
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
                ", youtube='" + youtube + '\'' +
                ", mainFileName='" + mainFileName + '\'' +
                ", mainPath='" + mainPath + '\'' +
                ", proFileName='" + proFileName + '\'' +
                ", proFilePath='" + proFilePath + '\'' +
                ", recipeWriter='" + recipeWriter + '\'' +
                ", mainInputFile=" + mainInputFile +
                ", recipePhotoDTOList=" + recipePhotoDTOList +
                ", recipeOrderList=" + recipeOrderList +
                '}';
    }
}
