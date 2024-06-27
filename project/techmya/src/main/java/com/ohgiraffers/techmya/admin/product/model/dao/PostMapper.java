package com.ohgiraffers.techmya.admin.product.model.dao;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductAndProductPostDTO;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<ProductAndProductPostDTO> getAllSellPost();

    List<ProductDTO> getAllProduct(int subCategoryNo);

    void registSellPost(int productNo, String productDesc, String productStatus, int shippingPeriod);
}
