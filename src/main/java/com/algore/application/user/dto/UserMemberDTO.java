package com.algore.application.user.dto;

import java.util.Date;

public class UserMemberDTO {
    private int memNum; //로그인 페이지 회원번호 식별
    private String username; //아이디
    private String name;  // 이름 불러
    private String nickName;
    private String password;
    private String birth;
    private String email;
    private String role;
    private String status;

    public UserMemberDTO() {
        super();
    }

    public UserMemberDTO(int memNum, String username, String name, String nickName, String password, String birth, String email, String role, String status) {
        this.memNum = memNum;
        this.username = username;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.birth = birth;
        this.email = email;
        this.role = role;
        this.status = status;
    }

    public int getMemNum() {
        return memNum;
    }

    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserMemberDTO{" +
                "memNum=" + memNum +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
