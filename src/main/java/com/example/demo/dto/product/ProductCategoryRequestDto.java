package com.example.demo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCategoryRequestDto {
    private int category_id;
    private String parentCategoryName;
    private String childCategoryName;
    private String subCategoryName;

}
