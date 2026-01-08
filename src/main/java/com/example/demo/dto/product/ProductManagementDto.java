package com.example.demo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductManagementDto {
    private int product_id;
    private String barcode;
    private int category_id;
    private String product_name;
    private String image_path;
    private int safety_stock;
    private int hq_supply_price;
}
