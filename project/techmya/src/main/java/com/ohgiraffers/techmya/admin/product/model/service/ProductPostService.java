package com.ohgiraffers.techmya.admin.product.model.service;

import com.ohgiraffers.techmya.admin.product.model.dao.PostMapper;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductAndProductPostDTO;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductPostService {

    private final PostMapper postMapper;

    public ProductPostService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<ProductAndProductPostDTO> getAllSellPost() {

        return postMapper.getAllSellPost();
    }

    public List<ProductDTO> getAllProduct(int subCategoryNo) {

        return postMapper.getAllProduct(subCategoryNo);
    }

    public void registSellPost(int productNo, String productDesc, String productStatus, int shippingPeriod) {

        postMapper.registSellPost(productNo, productDesc, productStatus, shippingPeriod);
    }
}
