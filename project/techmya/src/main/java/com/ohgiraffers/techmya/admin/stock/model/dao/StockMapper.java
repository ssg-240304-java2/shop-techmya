package com.ohgiraffers.techmya.admin.stock.model.dao;

import com.ohgiraffers.techmya.stock.model.dto.outputStockDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    List<outputStockDTO> searchStock(String searchInfo);
}
