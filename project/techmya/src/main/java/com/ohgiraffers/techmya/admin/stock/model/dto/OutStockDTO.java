package com.ohgiraffers.techmya.admin.stock.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OutStockDTO {

    private int outNo;
    private int outQuantity;
    private String outDate;
    private int orderNo;
    private int stockNo;
}
