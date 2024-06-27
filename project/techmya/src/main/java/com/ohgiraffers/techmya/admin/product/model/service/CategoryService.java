package com.ohgiraffers.techmya.admin.product.model.service;

import com.ohgiraffers.techmya.admin.product.model.dao.CategoryMapper;
import com.ohgiraffers.techmya.admin.product.model.dto.ProductCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public List<String> getAllParentCategories() {

        return categoryMapper.getAllParentCategories();
    }

    public List<ProductCategoryDTO> getSubCategories(int parentId) {

        log.info("[CategoryService] parentCategoryId = {}", parentId);

        return categoryMapper.getSubCategories(parentId);
    }
}
