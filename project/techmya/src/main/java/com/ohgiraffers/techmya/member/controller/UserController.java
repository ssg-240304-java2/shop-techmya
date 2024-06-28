package com.ohgiraffers.techmya.member.controller;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import com.ohgiraffers.techmya.member.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    public String authenticateUser(@RequestParam String userId, @RequestParam String userPw, HttpSession session) {
        UserDTO authenticatedUser = userService.authenticateUser(userId, userPw);

        if (authenticatedUser != null) {
            userService.logUserLogin(authenticatedUser.getUserNo());
            session.setAttribute("adminName", authenticatedUser.getUserName());

            if (authenticatedUser.getUserAuth() == 1) {
                return "admin-main";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
