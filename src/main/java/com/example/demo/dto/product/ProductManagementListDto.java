package com.example.demo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductManagementListDto {
    private int product_id;
    private String barcode;
    private int category_id;
    private String product_name;
    private String image_path;
    private int safety_stock;
    private int hq_supply_price;
    private String category_name;
    private String parentCategoryName;
    private String childCategoryName;
    private int hq_quantity;
    private String status;
}
