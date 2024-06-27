package com.ohgiraffers.techmya.admin.stock.model.service;


import com.ohgiraffers.techmya.admin.stock.model.dao.StockMapper;
import com.ohgiraffers.techmya.admin.stock.model.dto.inputStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.dto.outputStockDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImp implements StockService {


    private final StockMapper stockMapper;

    public StockServiceImp(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }


    @Override
    public List<outputStockDTO> searchStock(String searchInfo) {

        List<outputStockDTO> list = stockMapper.searchStock(searchInfo);

        if (list != null && !list.isEmpty()) {
            for (outputStockDTO stock : list) {
                System.out.println(stock);
            }
        } else {
            System.out.println("비어있어요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        return list;
    }

    @Override
    public Integer checkOption(int number, String option) {

        Integer result = stockMapper.checkOption(number,option);

        if(result != null){
            return result;
        } else {
            return 0;
        }
    }

    @Override
    public int searchOpt(String option) {

        return stockMapper.searchOpt(option);
    }

    @Override
    public int inputStock(int num, int optionNo, int amount) {
        System.out.println("optionNo = " + optionNo);
        System.out.println("amount = " + amount);
        System.out.println("num = " + num);;
        return stockMapper.inputStock(num, optionNo, amount);
    }

    @Override
    public void inputStock2(int num, int amount) {
        stockMapper.inputStock2(num, amount);
    }
}
