package com.ohgiraffers.techmya.admin.product.model.dao;

import com.ohgiraffers.techmya.admin.product.model.dto.ProductCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<String> getAllParentCategories();

    List<ProductCategoryDTO> getSubCategories(int parentId);
}
