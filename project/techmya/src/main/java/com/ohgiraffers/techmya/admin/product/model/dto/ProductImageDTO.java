package com.ohgiraffers.techmya.admin.product.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductImageDTO {

    private int imageFileNo;
    private String originalFileName;
    private String storedFileName;
    private LocalDateTime createdDate;
    private Boolean isDeleted;
    private ProductPostDTO productPostNo;
}
