package com.ohgiraffers.techmya.admin.product.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductPostDTO {

    private int productPostNo;
    private String productDesc;
    private String productStatus;
    private int shippingPeriod;
    private int viewCount;
    private LocalDateTime enrolledDate;
    private LocalDateTime modifiedDate;
    private ProductDTO product;
}
