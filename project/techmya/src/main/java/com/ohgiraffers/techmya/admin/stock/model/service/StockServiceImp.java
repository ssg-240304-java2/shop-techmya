package com.ohgiraffers.techmya.admin.stock.model.service;


import com.ohgiraffers.techmya.stock.model.dao.StockMapper;
import com.ohgiraffers.techmya.stock.model.dto.outputStockDTO;
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
}
