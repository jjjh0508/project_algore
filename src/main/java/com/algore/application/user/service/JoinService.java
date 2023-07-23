package com.algore.application.user.service;

import com.algore.application.user.dao.JoinMapper;
import com.algore.application.user.dto.UserMemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {
    private final JoinMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public JoinService(JoinMapper mapper, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserMemberDTO> selectAll() { //프론트 화면
        List<UserMemberDTO> dto = mapper.selectAll();
        return dto;
    }
//멤버DTO리턴 -- 주석하면 화면 호출된다 아래부분 수정 해 봐잉~

    public List<UserMemberDTO> getAllMembers() {
        return mapper.selectAll();
    }



    public int registUser(UserMemberDTO insertUserMemberDTO) {
        insertUserMemberDTO.setPassword(passwordEncoder.encode(insertUserMemberDTO.getPassword()));
        int result = 0;
        try {
            result = mapper.registUser(insertUserMemberDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}


