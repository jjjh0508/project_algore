package com.algore.application.kitchenguide.dto;

import java.util.List;

public class TrimDTO {
    private int trimNum; //손질번호
    private String trimTitle; //손질제목
    private String trimDetail; //손질내용
    private int trimViews; //조회수
    private String trimVideoLink; //동영상링크
    private String trimStatus; // 상태
    private List<TrimProcedureDTO> trimProcedureDTOList; // 손질법 순서 , XML 값 작성할때 힘듦,,,

    public TrimDTO() {
    }

    public TrimDTO(int trimNum, String trimTitle, String trimDetail, int trimViews, String trimVideoLink, String trimStatus, List<TrimProcedureDTO> trimProcedureDTOList) {
        this.trimNum = trimNum;
        this.trimTitle = trimTitle;
        this.trimDetail = trimDetail;
        this.trimViews = trimViews;
        this.trimVideoLink = trimVideoLink;
        this.trimStatus = trimStatus;
        this.trimProcedureDTOList = trimProcedureDTOList;
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

    public String getTrimStatus() {
        return trimStatus;
    }

    public void setTrimStatus(String trimStatus) {
        this.trimStatus = trimStatus;
    }

    public List<TrimProcedureDTO> getTrimProcedureDTOList() {
        return trimProcedureDTOList;
    }

    public void setTrimProcedureDTOList(List<TrimProcedureDTO> trimProcedureDTOList) {
        this.trimProcedureDTOList = trimProcedureDTOList;
    }

    @Override
    public String toString() {
        return "TrimDTO{" +
                "trimNum=" + trimNum +
                ", trimTitle='" + trimTitle + '\'' +
                ", trimDetail='" + trimDetail + '\'' +
                ", trimViews=" + trimViews +
                ", trimVideoLink='" + trimVideoLink + '\'' +
                ", trimStatus='" + trimStatus + '\'' +
                ", trimProcedureDTOList=" + trimProcedureDTOList +
                '}';
    }
}
