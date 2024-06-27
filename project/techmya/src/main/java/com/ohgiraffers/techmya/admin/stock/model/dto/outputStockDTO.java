package com.ohgiraffers.techmya.admin.stock.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class outputStockDTO {

    private int stockNo;
    private int productNo;
    private String productName;
    private String productOption;
    private String productOptionNo;
    private int stockQuantity;
    private String productStatus;
}
