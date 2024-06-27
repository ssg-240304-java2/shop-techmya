package com.ohgiraffers.techmya.admin.stock.model.service;

import com.ohgiraffers.techmya.admin.stock.model.dto.OutStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.dto.outputStockDTO;
import com.ohgiraffers.techmya.admin.stock.model.dto.InWHDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockService {
    List<outputStockDTO> searchStock(String searchInfo);

    Integer checkOption(int number, String option);

    @Transactional
    int inputStock(int number, int optionNo, int amount);

    int searchOpt(String option);

    void inputStock2(int num, int amount);

    List<InWHDTO> findInstock(String searchInstock);

    List<OutStockDTO> selectAll();
}
