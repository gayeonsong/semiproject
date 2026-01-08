package com.example.demo.mapper.product;

import com.example.demo.dto.product.ProductManagementDto;
import com.example.demo.dto.product.ProductManagementListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductManagementMapper {
    int insert(ProductManagementDto dto);
    List<ProductManagementListDto> selectAll(Map<String,Object> map);
    int barcodeExist(String barcode);
    int selectRowCount();
    ProductManagementListDto selectItem(int product_id);
    int updateProductInfo(ProductManagementDto dto);
}
