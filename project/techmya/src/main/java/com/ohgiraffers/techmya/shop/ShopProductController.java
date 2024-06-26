package com.ohgiraffers.techmya.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopProductController {

    @GetMapping("products")
    public String pageShopProducts(){
        return "shop/products";
    }
}
