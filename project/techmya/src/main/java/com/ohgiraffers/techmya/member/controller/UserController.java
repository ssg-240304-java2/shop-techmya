package com.ohgiraffers.techmya.member.controller;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import com.ohgiraffers.techmya.member.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/index.html"; // 정적 리소스 경로로 리다이렉트
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // signup.html 페이지로 이동
    }

    @GetMapping("/register")
    public @ResponseBody String registerUser(
            @RequestParam String userId,
            @RequestParam String userPw,
            @RequestParam String userAuth,
            @RequestParam String userName,
            @RequestParam String userBirth,
            @RequestParam String userPhone,
            @RequestParam String userEmail) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userId);
            userDTO.setUserPw(userPw);
            userDTO.setUserAuth(userAuth);
            userDTO.setUserName(userName);
            userDTO.setUserBirth(userBirth);
            userDTO.setUserPhone(userPhone);
            userDTO.setUserEmail(userEmail);
            userService.registerUser(userDTO); // 회원가입 시도
            return "success"; // 성공적으로 처리된 경우
        } catch (Exception e) {
            return "fail"; // 실패한 경우
        }
    }

    @GetMapping("/checkUserId")
    public @ResponseBody String checkUserIdExists(@RequestParam String userId) {
        if (userService.isUserIdExists(userId)) {
            return "exists"; // 이미 존재하는 아이디인 경우
        } else {
            return "available"; // 사용 가능한 아이디인 경우
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login"; // templates/member/login.html 페이지로 이동
    }

    @GetMapping("/authenticate")
    public @ResponseBody UserDTO authenticateUser(
            @RequestParam String userId,
            @RequestParam String userPw) {
        UserDTO authenticatedUser = userService.authenticateUser(userId, userPw);

        if (authenticatedUser != null) {
            return authenticatedUser; // 로그인 성공
        } else {
            return null; // 로그인 실패
        }
    }
}
