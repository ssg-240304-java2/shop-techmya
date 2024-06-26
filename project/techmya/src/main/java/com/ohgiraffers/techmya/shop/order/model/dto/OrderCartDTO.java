package com.ohgiraffers.techmya.shop.order.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderCartDTO {

//    private int detailOrderNo;
    private int productNo;
    private int productOptionNo;
    private int detailOrderAmount;
    private int totalPrice;
    private int userNo;
    private int orderNo;


    public OrderCartDTO(int productNo, int productOptionNo, int detailOrderAmount, int userNo) {
        this.productNo = productNo;
        this.productOptionNo = productOptionNo;
        this.detailOrderAmount = detailOrderAmount;
        this.userNo = userNo;
    }
}
