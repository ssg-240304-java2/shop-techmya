package com.ohgiraffers.techmya.member.model.service;

import com.ohgiraffers.techmya.member.model.dao.UserMapper;
import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional
    public void insertUser(UserDTO userDTO) {
        userMapper.insertUser(userDTO);
        userMapper.insertPersonalInfo(userDTO.getUserName(), userDTO.getUserBirth(), userDTO.getUserPhone(), userDTO.getUserEmail(), userDTO.getUserNo());
    }

    public boolean isUserIdExists(String userId) {
        Integer count = userMapper.countByUserId(userId);
        return count != null && count > 0;
    }

    public UserDTO authenticateUser(String userId, String userPw) {
        return userMapper.authenticateUser(userId, userPw);
    }

    public void logUserLogin(int userNo) {
        userMapper.insertLog(userNo, LocalDateTime.now());
    }
}
