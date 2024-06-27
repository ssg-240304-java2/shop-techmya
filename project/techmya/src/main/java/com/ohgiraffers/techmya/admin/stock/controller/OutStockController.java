package com.ohgiraffers.techmya.admin.stock.controller;


import com.ohgiraffers.techmya.admin.stock.model.dto.OutStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/outstock")
public class OutStockController {

    private final StockService stockService;

    public OutStockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/list")
    public String list(Model model) {

        List<OutStockDTO> OutStockList = stockService.selectAll();

        model.addAttribute("OutStockList", OutStockList);
        model.addAttribute("currentTab", "stockmain");    // html 탭 활성화
        return "admin/stock/outmanage";
    }
}
