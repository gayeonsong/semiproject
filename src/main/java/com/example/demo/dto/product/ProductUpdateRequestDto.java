package com.example.demo.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductUpdateRequestDto {
    private int product_id;
    private String subCategory;
    private String image_path;
    private MultipartFile newImgFile;
    private int hq_supply_price;
    private int safety_stock;
}
