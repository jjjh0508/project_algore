package com.algore.application.employee.dao;

import com.algore.application.auth.AuthUserDTO;
import com.algore.application.user.dto.UserMemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Mapper

public interface LoginTestMapper {
    AuthUserDTO loginSham(String username);



    // 아래의 메소드는 인메모리에서 테스트하기 위해 임시로 만든 값임
    // 회원가입관련 dto : 회원정보 joinMember
    UserMemberDTO joinMember(String Username);


}
