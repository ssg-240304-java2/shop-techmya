package com.ohgiraffers.techmya.admin.stock.controller;


import com.ohgiraffers.techmya.admin.stock.model.dto.inputStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.dto.outputStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {

    private static final Logger log = LoggerFactory.getLogger(StockController.class);
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

    @GetMapping("/stocklist")
    public String stocklist(Model model, @RequestParam(required = false) String searchInfo) {
        List<outputStockDTO> outStockList = stockService.searchStock(searchInfo);

        model.addAttribute("stockList", outStockList);
        return "/admin/stock/stockmain";
    }

    @PostMapping("/stockinput")
    public String stockinput(Model model, @RequestParam(required = false) int number,
                             @RequestParam(required = false) String option, @RequestParam(required = false) int amount) {
        int num = number;
        System.out.println(option);
        Integer optionNo = stockService.searchOpt(option);
        if (optionNo != 0) {
            stockService.inputStock(num, stockService.searchOpt(option), amount);
        } else {
            optionNo = 0;
            stockService.inputStock2(num, amount);
        }
        model.addAttribute("inputResult", "성공!!!!");


        return "/admin/stock/stockmain";
    }

    @GetMapping("/instock")
    public String inmanager() {
        return "/admin/stock/inmanage";
    }

//    @PostMapping("/instocklist")
//    public String instocklist() {
//
//
//    }








    @GetMapping("/outmanage")
    public String outmanager() {
        return "/admin/stock/outmanage";
    }
}
