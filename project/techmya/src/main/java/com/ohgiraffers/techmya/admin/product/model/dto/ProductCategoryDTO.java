package com.ohgiraffers.techmya.admin.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductCategoryDTO {

    private int categoryCode;
    private String categoryName;
    private int refCategoryCode;

    public ProductCategoryDTO(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public ProductCategoryDTO(int categoryCode, String categoryName, int refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }
}
