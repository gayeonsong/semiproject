package com.example.demo.service.product;

import com.example.demo.dto.product.ProductCategoryRequestDto;
import com.example.demo.dto.product.ProductParentCategoryRequestDto;
import com.example.demo.mapper.product.ProductCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryMapper mapper;

    public List<ProductCategoryRequestDto> childCategorySearch(String name){
        return mapper.childCategorySearch(name);
    }

    public List<ProductParentCategoryRequestDto> parentCategorySearch(){
        return mapper.parentCategorySearch();
    }

    public int searchCategoryId(String name){
        return mapper.searchCategoryId(name);
    }

    public List<ProductCategoryRequestDto> subCategorySearch(String name){
        return mapper.subCategorySearch(name);
    }

    public String searchCategoryName(int id){
        return mapper.searchCategoryName(id);
    }
}
