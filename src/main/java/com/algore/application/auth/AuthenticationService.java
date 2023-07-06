package com.algore.application.auth;

import com.algore.application.employee.dao.LoginTestMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService implements UserDetailsService {
    // 매퍼 등록 후 사용자의 이름으로 조회하는 로직

    private final LoginTestMapper loginTestMapper;

    public AuthenticationService(LoginTestMapper loginTestMapper) {
        this.loginTestMapper = loginTestMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 매퍼에서 쿼리 등록 해줘야함

        // mapper에서 가져와야함
        // 현재는 가상의 값을 넣어서 반환하는 로직으로 작성됨
        AuthUserDTO authUserDTO = loginTestMapper.loginSham(username);
        if(Objects.isNull(authUserDTO)){
          throw new UsernameNotFoundException("회원 정보가 없습니다.");
        }
        //회원 정보 조회하는 로직 작성 필요

        return authUserDTO;
    }
}
