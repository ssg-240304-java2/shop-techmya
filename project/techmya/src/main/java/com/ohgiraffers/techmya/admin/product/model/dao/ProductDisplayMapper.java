package com.ohgiraffers.techmya.admin.product.model.dao;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductAndProductPostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDisplayMapper {
    List<ProductAndProductPostDTO> getAllProducts(String productName);
}
