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
        return "member/signup"; // member/signup.html 페이지로 이동
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String userId,
                               @RequestParam String userPw,
                               @RequestParam String userName,
                               @RequestParam String userBirth,
                               @RequestParam String userPhone,
                               @RequestParam String userEmail) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUserPw(userPw);
        userDTO.setUserName(userName);
        userDTO.setUserBirth(userBirth);
        userDTO.setUserPhone(userPhone);
        userDTO.setUserEmail(userEmail);

        try {
            userService.registerUser(userDTO); // 회원가입 시도
            return "redirect:/login"; // 회원가입 성공 시 로그인 페이지로 이동
        } catch (Exception e) {
            return "redirect:/signup"; // 회원가입 실패 시 다시 회원가입 페이지로 이동
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

    @PostMapping("/authenticate")
    public @ResponseBody String authenticateUser(@RequestParam String userId, @RequestParam String userPw) {
        UserDTO authenticatedUser = userService.authenticateUser(userId, userPw);

        if (authenticatedUser != null) {
            if ("1".equals(authenticatedUser.getUserAuth())) {
                return "admin"; // 관리자 페이지로 리디렉션
            } else {
                return "user"; // 쇼핑몰 메인 페이지로 리디렉션
            }
        } else {
            return "fail"; // 로그인 실패
        }
    }
}
