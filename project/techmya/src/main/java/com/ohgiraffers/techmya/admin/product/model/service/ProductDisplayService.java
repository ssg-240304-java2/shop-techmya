package com.ohgiraffers.techmya.admin.product.model.service;

import com.ohgiraffers.techmya.admin.product.model.dao.ProductDisplayMapper;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductAndProductPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDisplayService {

    private final ProductDisplayMapper productDisplayMapper;

    public ProductDisplayService(ProductDisplayMapper productDisplayMapper) {
        this.productDisplayMapper = productDisplayMapper;
    }

    public List<ProductAndProductPostDTO> getAllProducts(String productName) {

        return productDisplayMapper.getAllProducts(productName);
    }
}
