package com.ohgiraffers.techmya.shop.order.model.dao;

import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int getProductPriceByProductNo(OrderCartDTO product);

    int getOptionPriceByOptionNo(OrderCartDTO product);

    void registNewOrder(OrderCartDTO product);

    void registNewCart(OrderCartDTO product);

    int getLastOrderNo();

    int checkProductAmount(OrderCartDTO product);

    int checkOptionAmount(OrderCartDTO product);

    int countOptions(int productNo);

    void updateCartWithOpt(OrderCartDTO product);

    void updateCartNoOpt(OrderCartDTO product);

    void updateOrder(OrderCartDTO product);
}
