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

    private String categoryNum;
    private Date recipeCreateDate;

    private String recipeIntro;

    private String tip;

    private String youtube;
    private String proFileName;  //프로필 파일이름
    private String proFilePath;  //프로필 파일 위치
    private String mainFileName;
    private String mainPath;

    private String newMainFileName;
    private String newMainPath;

    private String recipeWriter;

    private int allPrice;

    private MultipartFile mainInputFile;
    private List<RecipePhotoDTO> recipePhotoDTOList;
    private List<RecipeOrderDTO> recipeOrderList;

    private List<ModifyRecipeOrder> modifyRecipeOrders;

    private List<RecipeIngredientDTO> recipeIngredientDTOS;

    private List<IngredientDTO> ingredientDTOList;
    public RecipeviewDTO() {
    }

    public RecipeviewDTO(int recipeNum, String memName, String category, String recipeTitle, String recipeViews, String categoryNum, Date recipeCreateDate, String recipeIntro, String tip, String youtube, String proFileName, String proFilePath, String mainFileName, String mainPath, String newMainFileName, String newMainPath, String recipeWriter, int allPrice, MultipartFile mainInputFile, List<RecipePhotoDTO> recipePhotoDTOList, List<RecipeOrderDTO> recipeOrderList, List<ModifyRecipeOrder> modifyRecipeOrders, List<RecipeIngredientDTO> recipeIngredientDTOS, List<IngredientDTO> ingredientDTOList) {
        this.recipeNum = recipeNum;
        this.memName = memName;
        this.category = category;
        this.recipeTitle = recipeTitle;
        this.recipeViews = recipeViews;
        this.categoryNum = categoryNum;
        this.recipeCreateDate = recipeCreateDate;
        this.recipeIntro = recipeIntro;
        this.tip = tip;
        this.youtube = youtube;
        this.proFileName = proFileName;
        this.proFilePath = proFilePath;
        this.mainFileName = mainFileName;
        this.mainPath = mainPath;
        this.newMainFileName = newMainFileName;
        this.newMainPath = newMainPath;
        this.recipeWriter = recipeWriter;
        this.allPrice = allPrice;
        this.mainInputFile = mainInputFile;
        this.recipePhotoDTOList = recipePhotoDTOList;
        this.recipeOrderList = recipeOrderList;
        this.modifyRecipeOrders = modifyRecipeOrders;
        this.recipeIngredientDTOS = recipeIngredientDTOS;
        this.ingredientDTOList = ingredientDTOList;
    }

    public List<ModifyRecipeOrder> getModifyRecipeOrders() {
        return modifyRecipeOrders;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }

    public void setModifyRecipeOrders(List<ModifyRecipeOrder> modifyRecipeOrders) {
        this.modifyRecipeOrders = modifyRecipeOrders;
    }

    public List<IngredientDTO> getIngredientDTOList() {
        return ingredientDTOList;
    }

    public void setIngredientDTOList(List<IngredientDTO> ingredientDTOList) {
        this.ingredientDTOList = ingredientDTOList;
    }

    public String getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(String categoryNum) {
        this.categoryNum = categoryNum;
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

    public String getNewMainPath() {
        return newMainPath;
    }

    public void setNewMainPath(String newMainPath) {
        this.newMainPath = newMainPath;
    }

    public String getNewMainFileName() {
        return newMainFileName;
    }

    public void setNewMainFileName(String newMainFileName) {
        this.newMainFileName = newMainFileName;
    }

    public List<RecipeIngredientDTO> getRecipeIngredientDTOS() {
        return recipeIngredientDTOS;
    }

    public void setRecipeIngredientDTOS(List<RecipeIngredientDTO> recipeIngredientDTOS) {
        this.recipeIngredientDTOS = recipeIngredientDTOS;
    }

    @Override
    public String toString() {
        return "RecipeviewDTO{" +
                "recipeNum=" + recipeNum +
                ", memName='" + memName + '\'' +
                ", category='" + category + '\'' +
                ", recipeTitle='" + recipeTitle + '\'' +
                ", recipeViews='" + recipeViews + '\'' +
                ", categoryNum='" + categoryNum + '\'' +
                ", recipeCreateDate=" + recipeCreateDate +
                ", recipeIntro='" + recipeIntro + '\'' +
                ", tip='" + tip + '\'' +
                ", youtube='" + youtube + '\'' +
                ", proFileName='" + proFileName + '\'' +
                ", proFilePath='" + proFilePath + '\'' +
                ", mainFileName='" + mainFileName + '\'' +
                ", mainPath='" + mainPath + '\'' +
                ", newMainFileName='" + newMainFileName + '\'' +
                ", newMainPath='" + newMainPath + '\'' +
                ", recipeWriter='" + recipeWriter + '\'' +
                ", allPrice=" + allPrice +
                ", mainInputFile=" + mainInputFile +
                ", recipePhotoDTOList=" + recipePhotoDTOList +
                ", recipeOrderList=" + recipeOrderList +
                ", modifyRecipeOrders=" + modifyRecipeOrders +
                ", recipeIngredientDTOS=" + recipeIngredientDTOS +
                ", ingredientDTOList=" + ingredientDTOList +
                '}';
    }
}
