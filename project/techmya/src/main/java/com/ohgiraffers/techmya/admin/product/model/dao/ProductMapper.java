package com.ohgiraffers.techmya.admin.product.model.dao;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductMapper {
    // 상품 전체 조회
    List<ProductDTO> getAllProduct(String productName);

    void registNewProduct(String productName, int productPrice, int subCategoryId);
}
