package com.ohgiraffers.techmya.member.controller;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import com.ohgiraffers.techmya.member.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String userId,
                           @RequestParam String userPw,
                           @RequestParam String userName,
                           @RequestParam String userBirth,
                           @RequestParam String userPhone,
                           @RequestParam String userEmail) {
        if (userService.isUserIdExists(userId)) {
            return "redirect:/signup?error=exists";
        }
        LocalDateTime appendDate = LocalDateTime.now();
        UserDTO userDTO = new UserDTO(userId, userPw, userName, userBirth, userPhone, userEmail, appendDate);
        userService.insertUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/checkUserId")
    @ResponseBody
    public String checkUserId(@RequestParam String userId) {
        if (userService.isUserIdExists(userId)) {
            return "exists";
        } else {
            return "available";
        }
    }

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }


    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String userId, @RequestParam String userPw) {

        //확인코드 쓰기
        UserDTO authenticatedUser = userService.authenticateUser(userId, userPw);


        if (authenticatedUser != null) {
            // User is authenticated successfully

            // Log the user login
            userService.logUserLogin(authenticatedUser.getUserNo());

            // Check user authorization level
            if (authenticatedUser.getUserAuth() == 1) {
                // User is authorized as admin
                return "/admin-main"; // Return path to admin main page
            } else {
                // User is not admin, return path to regular index.html
                return "redirect:/";
            }
        } else {
            // User authentication failed, redirect to login page
            return "redirect:/login";
        }
    }
}
