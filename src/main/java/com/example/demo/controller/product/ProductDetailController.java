package com.example.demo.controller.product;

import com.example.demo.dto.product.ProductManagementListDto;
import com.example.demo.service.product.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductDetailController {
    private final ProductManagementService service;
    @GetMapping("/product/productDetail")
    public String productDetail(@RequestParam("product_id") int product_id, Model model){
        ProductManagementListDto productListDto=service.selectItem(product_id);
        model.addAttribute("productDetail",productListDto);
        return "product/productDetail";
    }
}
