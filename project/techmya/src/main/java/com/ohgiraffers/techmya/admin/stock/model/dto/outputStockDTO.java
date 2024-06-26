package com.ohgiraffers.techmya.admin.stock.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class outputStockDTO {

    private int stockNo;
    private int stockQuantity;
    private String stockName;
    private String stockOptions;
    private String stockStatus;
}
