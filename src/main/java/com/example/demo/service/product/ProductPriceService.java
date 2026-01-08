package com.example.demo.service.product;

import com.example.demo.mapper.product.ProductPriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductPriceService {
    private final ProductPriceMapper mapper;
    public int insert(Map<String,Object> map){
        return mapper.insert(map);
    }
}
