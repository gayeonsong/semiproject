package com.example.demo.service;

import com.example.demo.dto.ProductListDto;
import com.example.demo.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {
    private final ProductMapper productMapper;

    public List<ProductListDto> productList() {
        return productMapper.productList();
    }

}
