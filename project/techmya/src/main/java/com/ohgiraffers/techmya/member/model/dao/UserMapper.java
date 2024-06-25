package com.ohgiraffers.techmya.member.model.dao;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void insert(UserDTO userDTO);

    UserDTO findByUserId(@Param("userId") String userId);

    UserDTO authenticateUser(@Param("userId") String userId, @Param("userPw") String userPw);

    void insertLog(@Param("userNo") int userNo);
}
