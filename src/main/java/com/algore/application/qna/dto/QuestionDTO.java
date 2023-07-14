package com.algore.application.qna.dto;

public class QuestionDTO {
    private int qNumber;
    private String qTitle;
    private String qContent;
    private String qDate;
    private String status;
    private String ModiDate;
    private String nickname;

    public QuestionDTO(int qNumber, String qTitle, String qContent, String qDate, String status, String modiDate, String nickname) {
        this.qNumber = qNumber;
        this.qTitle = qTitle;
        this.qContent = qContent;
        this.qDate = qDate;
        this.status = status;
        ModiDate = modiDate;
        this.nickname = nickname;
    }

    public QuestionDTO() {
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getqNumber() {
        return qNumber;
    }

    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String getqDate() {
        return qDate;
    }

    public void setqDate(String qDate) {
        this.qDate = qDate;
    }




    public String getModiDate() {
        return ModiDate;
    }

    public void setModiDate(String modiDate) {
        ModiDate = modiDate;
    }



    @Override
    public String toString() {
        return "QuestionDTO{" +
                "qNumber=" + qNumber +
                ", qTitle='" + qTitle + '\'' +
                ", qContent='" + qContent + '\'' +
                ", qDate='" + qDate + '\'' +
                ", status='" + status + '\'' +
                ", ModiDate='" + ModiDate + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
