package com.example.demo.service.product;


import com.example.demo.dto.product.ProductManagementDto;
import com.example.demo.dto.product.ProductManagementListDto;
import com.example.demo.mapper.product.ProductManagementMapper;
import com.example.demo.mapper.product.ProductPriceMapper;
import com.example.demo.pageInfo.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ProductManagementService {
    private final ProductManagementMapper mapper;
    private final ProductPriceMapper productPriceMapper;

    public int insert(ProductManagementDto dto){
        return mapper.insert(dto);
    }
    public Map<String,Object> selectAll(int pageNum){
        int totalRow=mapper.selectRowCount();
        PageInfo pageInfo=new PageInfo(pageNum,7,5,totalRow);
        Map<String,Object> map=new HashMap<>();
        map.put("startrow",pageInfo.getStartRowNum());
        map.put("endrow",pageInfo.getEndRowNum());
        map.put("pageInfo",pageInfo);
        List<ProductManagementListDto>  productList=mapper.selectAll(map);
        map.put("productList",productList);
        return map;
    }

    public int barcodeExist(String barcode){
        return mapper.barcodeExist(barcode);
    }

    public ProductManagementListDto selectItem(int product_id){
        return mapper.selectItem(product_id);
    }
}
