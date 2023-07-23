package com.algore.application.recipe.dto;

import java.sql.Date;

public class CommentReadDTO {
    private String memNickName;
    private String conutent;

    private Date creatDate;

    private String profileName;
    private String profilePath;


    public CommentReadDTO() {
    }

    public CommentReadDTO(String memNickName, String conutent, Date creatDate, String profileName, String profilePath) {
        this.memNickName = memNickName;
        this.conutent = conutent;
        this.creatDate = creatDate;
        this.profileName = profileName;
        this.profilePath = profilePath;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getMemNickName() {
        return memNickName;
    }

    public void setMemNickName(String memNickName) {
        this.memNickName = memNickName;
    }

    public String getConutent() {
        return conutent;
    }

    public void setConutent(String conutent) {
        this.conutent = conutent;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    public String toString() {
        return "CommentReadDTO{" +
                "memNickName='" + memNickName + '\'' +
                ", conutent='" + conutent + '\'' +
                ", creatDate=" + creatDate +
                ", profileName='" + profileName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}
