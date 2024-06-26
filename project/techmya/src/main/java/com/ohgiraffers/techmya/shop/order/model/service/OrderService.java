package com.ohgiraffers.techmya.shop.order.model.service;

import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;

public interface OrderService {

    int registNewCart(OrderCartDTO product);

    int getPriceByProductNo(OrderCartDTO product);

    void updateCart(OrderCartDTO product);
}
