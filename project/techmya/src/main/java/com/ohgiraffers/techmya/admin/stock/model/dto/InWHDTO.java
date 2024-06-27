package com.ohgiraffers.techmya.admin.stock.model.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class InWHDTO {

    private int inNo;
    private String productName;
    private String productOption;
    private int inQuantity;
    private String inDate;
}
