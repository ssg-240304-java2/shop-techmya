package com.ohgiraffers.techmya.admin.order.model.dto;

import com.ohgiraffers.techmya.shop.order.model.dto.OrderCartDTO;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private int orderNo;
    private int orderPrice;
    private Date orderDate;
    private int userNo;
    private int orderStatusNo;

    private OrderCartDTO orderDetail;
}
