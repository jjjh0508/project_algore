package com.algore.application.kitchenguide.dto;

public class StorageDTO {

    private int stoNum; /*보관번호*/
    private String stoTitle; /*보관제목*/
    private String stoDetail; /*보관내용*/
    private String stoVideoLink; /*동영상링크*/
    private int stoViews; /*조회수*/

    public StorageDTO() {
    }

    public StorageDTO(int stoNum, String stoTitle, String stoDetail, String stoVideoLink, int stoViews) {
        this.stoNum = stoNum;
        this.stoTitle = stoTitle;
        this.stoDetail = stoDetail;
        this.stoVideoLink = stoVideoLink;
        this.stoViews = stoViews;
    }

    public int getStoNum() {
        return stoNum;
    }

    public void setStoNum(int stoNum) {
        this.stoNum = stoNum;
    }

    public String getStoTitle() {
        return stoTitle;
    }

    public void setStoTitle(String stoTitle) {
        this.stoTitle = stoTitle;
    }

    public String getStoDetail() {
        return stoDetail;
    }

    public void setStoDetail(String stoDetail) {
        this.stoDetail = stoDetail;
    }

    public String getStoVideoLink() {
        return stoVideoLink;
    }

    public void setStoVideoLink(String stoVideoLink) {
        this.stoVideoLink = stoVideoLink;
    }

    public int getStoViews() {
        return stoViews;
    }

    public void setStoViews(int stoViews) {
        this.stoViews = stoViews;
    }

    @Override
    public String toString() {
        return "StorageProcedureDTO{" +
                "stoNum=" + stoNum +
                ", stoTitle='" + stoTitle + '\'' +
                ", stoDetail='" + stoDetail + '\'' +
                ", stoVideoLink='" + stoVideoLink + '\'' +
                ", stoViews=" + stoViews +
                '}';
    }
}
