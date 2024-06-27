package com.ohgiraffers.techmya.admin.product.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ProductOptionDTO {

    private int productOptionNo;
    private String productOptionName;
    private int productOptionPrice;
    private ProductPostDTO productPostNo;
    private ProductDTO productNo;
}
