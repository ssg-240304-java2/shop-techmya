package com.ohgiraffers.techmya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("main")
    public String getAdmin(){

        return "admin/main";
    }

    @GetMapping("stock/stockmain")
    public String getStockMain(){
        return "admin/stock/stockmain";
    }
}
