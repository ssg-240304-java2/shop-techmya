package com.ohgiraffers.techmya.admin.product.model.service;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct(String productName);

    void registNewProduct(String productName, int productPrice, int subCategoryId);
}
