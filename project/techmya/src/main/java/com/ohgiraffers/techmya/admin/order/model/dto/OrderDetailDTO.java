package com.ohgiraffers.techmya.admin.order.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {

    private String productName;
    private String productOptionName;
    private int detailOrderAmount;
    private int totalPrice;

    @Override
    public String toString() {
        return "[" +
                "상품명 : '" + productName + '\'' +
                ", 옵션명 : '" + productOptionName + '\'' +
                ", 상품 주문 수량 : " + detailOrderAmount +
                ", 상품 금액 : " + totalPrice +
                ']' + "\n";
    }
}
