package com.ohgiraffers.techmya.member.model.service;

import com.ohgiraffers.techmya.member.model.dao.UserMapper;
import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void registerUser(UserDTO userDTO) {
        userMapper.insert(userDTO);
    }

    public boolean isUserIdExists(String userId) {
        return userMapper.findByUserId(userId) != null;
    }

    public UserDTO authenticateUser(String userId, String userPw) {
        UserDTO userDTO = userMapper.authenticateUser(userId, userPw);
        if (userDTO != null && userDTO.getUserPw().equals(userPw)) {
            return userDTO;
        } else {
            return null;
        }
    }
}
