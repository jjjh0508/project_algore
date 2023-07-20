package com.algore.application.user.service;

import com.algore.application.user.dao.JoinMapper;
import com.algore.application.user.dto.UserMemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {
    private final JoinMapper mapper;

    public JoinService(JoinMapper mapper) {
        this.mapper = mapper;
    }

    public List<UserMemberDTO> selectAll() { //프론트 화면
        List<UserMemberDTO> dto = mapper.selectAll();
        return dto;
    }

//    public List<UserMemberDTO> getAllMembers() {
//        return mapper.selectAll();
//    }
//
//    public int registUser(UserMemberDTO insertUserMemberDTO) {
//        int result = 0;
//        try {
//            result = mapper.registUser(insertUserMemberDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }


}


