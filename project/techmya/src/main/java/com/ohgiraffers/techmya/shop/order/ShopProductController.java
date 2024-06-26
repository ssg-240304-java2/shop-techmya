package com.ohgiraffers.techmya.shop.order;

import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
@Slf4j
public class ShopProductController {

    // 장바구니 리스트
    private List<OrderDetailDTO> productlist = new ArrayList<>();

    @GetMapping("products")
    public String pageShopProducts(){
        return "shop/products";
    }

    @GetMapping("order")
    public String pageOrderProduct(){
        return "shop/orderTest";
    }


    /**
     * 장바구니 리스트에 상품을 저장
     */
    @PostMapping("/cart")
    public String cartOrder(@ModelAttribute OrderDetailDTO product, Model model){

        log.info("[ShopProductController] cartOrder product : {}", product);

        productlist.add(product);
        model.addAttribute("productlist", productlist);

        return "shop/orderTest";
    }

    /**
     * 장바구니를 주문서로 저장
     */


}
