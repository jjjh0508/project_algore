package com.algore.application.kitchenguide.dto;

public class StorageProcedureDTO {
    private int spStepNum; /*단계번호*/
    private int stoNum; /*보관번호*/
    private String spFileName; /*파일명*/
    private String spDetail; /*내용*/
    private String spPath; /*저장경로*/

    public StorageProcedureDTO() {
    }

    public StorageProcedureDTO(int spStepNum, int stoNum, String spFileName, String spDetail, String spPath) {
        this.spStepNum = spStepNum;
        this.stoNum = stoNum;
        this.spFileName = spFileName;
        this.spDetail = spDetail;
        this.spPath = spPath;
    }

    public int getSpStepNum() {
        return spStepNum;
    }

    public void setSpStepNum(int spStepNum) {
        this.spStepNum = spStepNum;
    }

    public int getStoNum() {
        return stoNum;
    }

    public void setStoNum(int stoNum) {
        this.stoNum = stoNum;
    }

    public String getSpFileName() {
        return spFileName;
    }

    public void setSpFileName(String spFileName) {
        this.spFileName = spFileName;
    }

    public String getSpDetail() {
        return spDetail;
    }

    public void setSpDetail(String spDetail) {
        this.spDetail = spDetail;
    }

    public String getSpPath() {
        return spPath;
    }

    public void setSpPath(String spPath) {
        this.spPath = spPath;
    }

    @Override
    public String toString() {
        return "StorageProcedureDTO{" +
                "spStepNum=" + spStepNum +
                ", stoNum=" + stoNum +
                ", spFileName='" + spFileName + '\'' +
                ", spDetail='" + spDetail + '\'' +
                ", spPath='" + spPath + '\'' +
                '}';
    }
}
