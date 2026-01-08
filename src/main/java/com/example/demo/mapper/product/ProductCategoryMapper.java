package com.example.demo.mapper.product;

import com.example.demo.dto.product.ProductCategoryRequestDto;
import com.example.demo.dto.product.ProductParentCategoryRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    List<ProductCategoryRequestDto> childCategorySearch(String name);
    List<ProductParentCategoryRequestDto> parentCategorySearch();
    int searchCategoryId(String name);
    List<ProductCategoryRequestDto> subCategorySearch(String name);
    String searchCategoryName(int id);
}
