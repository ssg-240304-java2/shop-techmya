package com.ohgiraffers.techmya.admin.stock.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class inputStockDTO {

    private int stockNo;
    private int stockQuantity;
    private int productNo;
    private int productOptionNo;
}