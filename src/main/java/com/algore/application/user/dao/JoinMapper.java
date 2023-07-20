package com.algore.application.user.dao;

import com.algore.application.user.dto.UserMemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinMapper {
    List<UserMemberDTO>selectAll();
//    void registUser(InsertmemberDTO insertmemberDTO);

}
