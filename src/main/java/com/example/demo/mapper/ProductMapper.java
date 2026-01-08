package com.example.demo.mapper;

import com.example.demo.dto.ProductListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductListDto> productList();


}
