package com.algore.application.kitchenguide.dto;

public class TrimDTO {
    private int trimNum; //손질번호
    private String trimTitle; //손질제목
    private String trimDetail; //손질내용
    private int trimSequence; //손질순서
    private int trimViews; //조회수
    private String trimVideoLink; //동영상링크

    public TrimDTO() {
    }

    public TrimDTO(int trimNum, String trimTitle, String trimDetail, int trimSequence, int trimViews, String trimVideoLink) {
        this.trimNum = trimNum;
        this.trimTitle = trimTitle;
        this.trimDetail = trimDetail;
        this.trimSequence = trimSequence;
        this.trimViews = trimViews;
        this.trimVideoLink = trimVideoLink;
    }

    public int getTrimNum() {
        return trimNum;
    }

    public void setTrimNum(int trimNum) {
        this.trimNum = trimNum;
    }

    public String getTrimTitle() {
        return trimTitle;
    }

    public void setTrimTitle(String trimTitle) {
        this.trimTitle = trimTitle;
    }

    public String getTrimDetail() {
        return trimDetail;
    }

    public void setTrimDetail(String trimDetail) {
        this.trimDetail = trimDetail;
    }

    public int getTrimSequence() {
        return trimSequence;
    }

    public void setTrimSequence(int trimSequence) {
        this.trimSequence = trimSequence;
    }

    public int getTrimViews() {
        return trimViews;
    }

    public void setTrimViews(int trimViews) {
        this.trimViews = trimViews;
    }

    public String getTrimVideoLink() {
        return trimVideoLink;
    }

    public void setTrimVideoLink(String trimVideoLink) {
        this.trimVideoLink = trimVideoLink;
    }

    @Override
    public String toString() {
        return "TrimDTO{" +
                "trimNum=" + trimNum +
                ", trimTitle='" + trimTitle + '\'' +
                ", trimDetail='" + trimDetail + '\'' +
                ", trimSequence=" + trimSequence +
                ", trimViews=" + trimViews +
                ", trimVideoLink='" + trimVideoLink + '\'' +
                '}';
    }

}
