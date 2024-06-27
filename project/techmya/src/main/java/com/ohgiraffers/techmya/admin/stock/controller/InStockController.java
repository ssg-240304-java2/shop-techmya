package com.ohgiraffers.techmya.admin.stock.controller;


import com.ohgiraffers.techmya.admin.stock.model.dto.InWHDTO;
import com.ohgiraffers.techmya.admin.stock.model.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/instock")
public class InStockController {

    private final StockService stockService;

    public InStockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/instocklist")
    public String inStockList(Model model, @RequestParam(required = false) String searchInstock) {
        List<InWHDTO> inStockList = stockService.findInstock(searchInstock);

        model.addAttribute("inStockList", inStockList);
        return "/admin/stock/inmanage";
    }
}
