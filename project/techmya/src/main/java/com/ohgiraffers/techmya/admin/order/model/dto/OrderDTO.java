package com.ohgiraffers.techmya.admin.order.model.dto;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

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

    private OrderDetailDTO orderDetail;
}
