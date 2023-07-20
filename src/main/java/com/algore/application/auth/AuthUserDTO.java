package com.algore.application.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class AuthUserDTO implements UserDetails {

    // 회원 정보 데이터 필요
    private int memNum; //로그인페이지 회원번호 식별

    private String username; //로그인 아이디

    private String password;  //로그인 비밀번호
 
    private String nickName;
    private String role;
//    private ArrayList<GrantedAuthority> role;


    public AuthUserDTO() {
    }

    public AuthUserDTO(int memNum, String username, String password, String nickName, String role) {
        this.memNum = memNum;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.role = role;
    }

    public int getMemNum() {
        return memNum;
    }

    public void setMemNum(int memNum) {
        this.memNum = memNum;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(role));
        return authList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부의 대한 값을 리턴한다.
        // true는 만료되지 않음
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부의 대한 값을 리턴한다.
        // true는 잠기지 않음
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 패스워드 만료가 되었는지 여부를 리턴한다.
        // true면 만료가 아님
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 사용가능한 계정인지 여부를 확인한다.
        // true면 사용가능
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthUserDTO{" +
                "memNum=" + memNum +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", role=" + role +
                '}';
    }
}
