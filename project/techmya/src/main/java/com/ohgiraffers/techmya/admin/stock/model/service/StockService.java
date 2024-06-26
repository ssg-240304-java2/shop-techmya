package com.ohgiraffers.techmya.admin.stock.model.service;

import com.ohgiraffers.techmya.stock.model.dto.outputStockDTO;

import java.util.List;

public interface StockService {
    List<outputStockDTO> searchStock(String searchInfo);
}
