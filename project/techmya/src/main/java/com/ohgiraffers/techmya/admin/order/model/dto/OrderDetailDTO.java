package com.ohgiraffers.techmya.admin.order.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private int detailOrderNo;
    private int detailOrderAmount;
    private int orderNo;
    private int productNo;
    private int productOptionNo;
}
