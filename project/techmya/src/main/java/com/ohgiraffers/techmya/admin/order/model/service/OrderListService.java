package com.ohgiraffers.techmya.admin.order.model.service;

import com.ohgiraffers.techmya.admin.common.SelectCriteria;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.techmya.admin.order.model.dto.OrderDetailListDTO;

import java.util.List;

public interface OrderListService {
    List<OrderDTO> getOrderList();

    int selectTotalCount();

    List<OrderDTO> findAllOrder(SelectCriteria selectCriteria);

}
