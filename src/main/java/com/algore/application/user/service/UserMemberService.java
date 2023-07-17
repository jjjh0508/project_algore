package com.algore.application.user.service;

import com.algore.application.user.dao.UserMemberMapper;
import com.algore.application.user.dto.UserMemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMemberService {
    private final UserMemberMapper mapper;

    public UserMemberService(UserMemberMapper mapper) {this.mapper = mapper;}

    public  List<UserMemberDTO> userList() {
        List<UserMemberDTO> selectList = mapper.selectAll();
        return selectList;
    }

//    public List<UserMemberDTO> selectAll(){
//
//        return selectList;
//    }

}
