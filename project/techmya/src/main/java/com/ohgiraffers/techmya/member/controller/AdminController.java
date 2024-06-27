package com.ohgiraffers.techmya.member.controller;

import com.ohgiraffers.techmya.member.model.dto.UserDTO;
import com.ohgiraffers.techmya.member.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/main")
    public String adminMain(HttpSession session, Model model) {
        String adminName = (String) session.getAttribute("adminName");
        model.addAttribute("adminName", adminName);

        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin-main";
    }
}
