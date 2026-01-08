package com.example.demo.mapper.product;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductPriceMapper {
    int insert(Map<String,Object> map);
}
