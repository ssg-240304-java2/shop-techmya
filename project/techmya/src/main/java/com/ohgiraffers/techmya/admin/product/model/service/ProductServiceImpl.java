package com.ohgiraffers.techmya.admin.product.model.service;

import com.ohgiraffers.techmya.admin.product.model.dao.ProductMapper;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProduct(String productName) {
        log.info("[ProductServiceImpl] getAllProduct = {}", productName);

        return productMapper.getAllProduct(productName);
    }

    @Override
    @Transactional
    public void registNewProduct(String productName, int productPrice, int subCategoryId) {
        log.info("[ProductServiceImpl] registNewProduct = {}", productName);

        productMapper.registNewProduct(productName, productPrice, subCategoryId);
    }
}
