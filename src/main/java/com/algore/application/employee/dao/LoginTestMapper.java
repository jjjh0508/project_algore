package com.algore.application.employee.dao;

import com.algore.application.auth.AuthUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class LoginTestMapper {

    private final PasswordEncoder passwordEncoder;

    public LoginTestMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    // 아래의 메소드는 인메모리에서 테스트하기 위해 임시로 만든 값임
    public AuthUserDTO loginSham(String username){
        AuthUserDTO authUserDTO = null;
        Collection<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        // DB에서 조회한 결과가 있다고 가정함
        if(username.equals("user2@gmail.com")){
            String pass = passwordEncoder.encode("pass");

            authUserDTO = new AuthUserDTO(1, "user2@gmail.com", pass, list);
        }
        return authUserDTO;
    }

}
