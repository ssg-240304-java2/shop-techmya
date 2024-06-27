package com.ohgiraffers.techmya.admin.stock.model.dao;

import com.ohgiraffers.techmya.admin.stock.model.dto.InWHDTO;
import com.ohgiraffers.techmya.admin.stock.model.dto.outputStockDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {

    List<outputStockDTO> searchStock(String searchInfo);

    Integer checkOption(int number, String option);

    int inputStock(int number, int optionNo, int amount );

    int searchOpt(String option);

    void inputStock2(int num, int amount);

    List<InWHDTO> findInstock(String searchInstock);
}
