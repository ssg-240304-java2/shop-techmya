package com.ohgiraffers.techmya.member.model.dao;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {

    int insertUser(UserDTO userDTO);

    void insertPersonalInfo(@Param("userName") String userName,
                            @Param("userBirth") String userBirth,
                            @Param("userPhone") String userPhone,
                            @Param("userEmail") String userEmail,
                            @Param("userNo") int userNo);

    int countByUserId(@Param("userId") String userId);

    UserDTO authenticateUser(@Param("userId") String userId, @Param("userPw") String userPw);

    void insertLog(@Param("userNo") int userNo, @Param("logDate") LocalDateTime logDate);
    List<UserDTO> getAllUsers();
}
