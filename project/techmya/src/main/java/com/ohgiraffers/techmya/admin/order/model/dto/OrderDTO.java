package com.ohgiraffers.techmya.admin.order.model.dto;

import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;
import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderNo;
    private int orderPrice;
    private String orderDate;
    private String userId;

    private List<OrderDetailDTO> orderDetailList;

    private String orderStatus;

    public OrderDTO(int orderNo, int orderPrice, String orderDate, String userId, String orderStatus) {
        this.orderNo = orderNo;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }
}
