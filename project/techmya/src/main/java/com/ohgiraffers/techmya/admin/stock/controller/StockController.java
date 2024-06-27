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



    @PostMapping("/stockmain")
    public String stockmain(Model model) {

        model.addAttribute("currentPage", "stock");

        return "/admin/stock/stockmain";
    }
//    @GetMapping("/stockmain")
//    public String stockmain2() {
//        return "/admin/stock/stockmain";
//    }

    @GetMapping("/stocklist")
    public String stocklist(Model model, @RequestParam(required = false) String searchInfo) {
        List<outputStockDTO> outStockList = stockService.searchStock(searchInfo);

        model.addAttribute("stockList", outStockList);
        model.addAttribute("currentPage", "stock");

        return "/admin/stock/stockmain";
    }

    @GetMapping("/stockmain")
    public String stockMain(Model model) {
        model.addAttribute("currentPage", "stock");
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
            stockService.inputStock2(num, amount);
        }
        model.addAttribute("inputResult", "성공!!!!");
        model.addAttribute("currentTab", "stockmain");    // html 탭 활성화
        model.addAttribute("currentPage", "stock");

        return "/admin/stock/stockmain";
    }

    @PostMapping("/instock")
    public String inmanager(Model model) {

        model.addAttribute("currentPage", "stock");
        return "/admin/stock/inmanage";
    }


    @PostMapping("/stockmain2")
    public String inmanager2() {
        return "/admin/stock/stockmain";
    }




    @PostMapping("outstock")
    public String outmanager(Model model) {

        model.addAttribute("currentPage", "stock");
        return "/admin/stock/outmanage";
    }
}
