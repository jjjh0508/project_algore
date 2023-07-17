package com.algore.application.user.dao;

import com.algore.application.user.dto.UserMemberDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper

public interface UserMemberMapper {
    List<UserMemberDTO> selectAll();

}
