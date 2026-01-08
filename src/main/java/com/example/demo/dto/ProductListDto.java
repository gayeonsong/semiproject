package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductListDto {
    private int product_id;
    private String category_name;
    private String product_name;
    private int hq_quantity;
    private int hq_supply_price;
}
