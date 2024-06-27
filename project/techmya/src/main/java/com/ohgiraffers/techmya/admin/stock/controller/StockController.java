package com.ohgiraffers.techmya.admin.stock.controller;


import com.ohgiraffers.techmya.admin.stock.model.dto.outputStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stockmain")
    public String stockmain() {
        return "/admin/stock/stockmain";
    }

    @GetMapping("/stockmanage")
    public String stockmanager() {
        return "/admin/stock/stockmanage";
    }

    @PostMapping("/stocklist")
    public String stocklist(Model model, @RequestParam(required = false) String searchInfo) {
        List<outputStockDTO> outStockList = stockService.searchStock(searchInfo);
        for (outputStockDTO stock : outStockList) {
            System.out.println(stock);
        }
        model.addAttribute("stockList", outStockList);
        return "/admin/stock/stockmain";
    }

    @GetMapping("/inmanage")
    public String inmanager() {
        return "/admin/stock/inmanage";
    }

    @GetMapping("/outmanage")
    public String outmanager() {
        return "/admin/stock/outmanage";
    }
}
