package com.algore.application.user.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class UserMemberDTO implements UserDetails {
    private int MEM_NUM;
    private String NAME;
    private String ID;
    private String NICKNAME;
    private String PASSWORD;
    private Date BIRTH;
    private String EMAIL;
    private Date STRAT_DATE;
    private String MEM_STATUS;
    private String ADMIN;

    private Collection<GrantedAuthority> role;

    public UserMemberDTO() {

    }

    public UserMemberDTO(int MEM_NUM, String NAME, String ID, String NICKNAME, String PASSWORD, Date BIRTH, String EMAIL, Date STRAT_DATE, String MEM_STATUS, String ADMIN) {
        this.MEM_NUM = MEM_NUM;
        this.NAME = NAME;
        this.ID = ID;
        this.NICKNAME = NICKNAME;
        this.PASSWORD = PASSWORD;
        this.BIRTH = BIRTH;
        this.EMAIL = EMAIL;
        this.STRAT_DATE = STRAT_DATE;
        this.MEM_STATUS = MEM_STATUS;
        this.ADMIN = ADMIN;
        this.role = role;
    }

    public int getMEM_NUM() {
        return MEM_NUM;
    }

    public void setMEM_NUM(int MEM_NUM) {
        this.MEM_NUM = MEM_NUM;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNICKNAME() {
        return NICKNAME;
    }

    public void setNICKNAME(String NICKNAME) {
        this.NICKNAME = NICKNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Date getBIRTH() {
        return BIRTH;
    }

    public void setBIRTH(Date BIRTH) {
        this.BIRTH = BIRTH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Date getSTRAT_DATE() {
        return STRAT_DATE;
    }

    public void setSTRAT_DATE(Date STRAT_DATE) {
        this.STRAT_DATE = STRAT_DATE;
    }

    public String getMEM_STATUS() {
        return MEM_STATUS;
    }

    public void setMEM_STATUS(String MEM_STATUS) {
        this.MEM_STATUS = MEM_STATUS;
    }

    public String getADMIN() {
        return ADMIN;
    }

    public void setADMIN(String ADMIN) {
        this.ADMIN = ADMIN;
    }

    @Override
    public String toString() {
        return "UserMemberDTO{" +
                "MEM_NUM='" + MEM_NUM + '\'' +
                ", NAME='" + NAME + '\'' +
                ", ID='" + ID + '\'' +
                ", NICKNAME='" + NICKNAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", BIRTH=" + BIRTH +
                ", EMAIL='" + EMAIL + '\'' +
                ", STRAT_DATE=" + STRAT_DATE +
                ", MEM_STATUS='" + MEM_STATUS + '\'' +
                ", ADMIN='" + ADMIN + '\'' +
                '}';
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
