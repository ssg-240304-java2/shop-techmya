package com.ohgiraffers.techmya.shop.order.model.service;

import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;

import java.util.List;

public interface OrderService {

    int registNewCart(OrderCartDTO product);

    int getPriceByProductNo(OrderCartDTO product);

    void updateCart(OrderCartDTO product);

    List<OrderDTO> findAllOrderProduct();
}
