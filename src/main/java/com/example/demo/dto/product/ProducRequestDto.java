package com.example.demo.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProducRequestDto {
    private int product_id;
    @NotBlank(message="필수입력 사항입니다.")
    private String barcode;
    @NotBlank(message="필수입력 사항입니다.")
    private String category_name;
    private String product_name;
    @NotNull(message = "이미지를 등록하세요.")
    private MultipartFile file1;
    @Min(value = 1, message = "최소 안전재고 수량은 1개입니다.")
    private int safety_stock;
    @Min(value = 1,  message="상품가격을 등록하세요")
    private int hq_supply_price;
}
