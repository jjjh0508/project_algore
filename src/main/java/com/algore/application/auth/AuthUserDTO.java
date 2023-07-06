package com.algore.application.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUserDTO implements UserDetails   {

    // 회원 정보 데이터 필요
    private int memberCode;
    private String memberId;
    private String memberPass;
    private Collection<GrantedAuthority> role;

    public AuthUserDTO() {
    }

    public AuthUserDTO(int memberCode, String memberId, String memberPass, Collection<GrantedAuthority> role) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberPass = memberPass;
        this.role = role;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }


    @Override
    public String toString() {
        return "AuthUserDTO{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPass='" + memberPass + '\'' +
                '}';
    }

    // userDtails 정보

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authoriCollection = new ArrayList<>();
//        // 사용자의 권한 목록을 String으로 가지고 있으며 구분은 ,로 하는 경우 ,를 기준으로 list를 만들어 권한 목록을 추가한다.
//        for (String role : role.split(",")){
//            authoriCollection.add(new SimpleGrantedAuthority(role));
//        }
//        System.out.println(authoriCollection);
        // 권한 목록 전달
        return this.role;
    }

    @Override
    public String getPassword() {
        // 사용자의 비밀번호 매핑
        return memberPass;
    }

    @Override
    public String getUsername() {
        // 사용자의 아이디 매핑
        return memberId;
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
}
