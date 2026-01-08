package com.example.demo.controller.product;

import com.example.demo.service.product.ProductCategoryService;
import com.example.demo.service.product.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductManagementController {
    private final ProductManagementService service;
    private final ProductCategoryService productCategoryService;

    @GetMapping("/product/productManagement")
    public String productManagement(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum ,Model model){
        Map<String, Object> map=service.selectAll(pageNum);
        model.addAttribute("productList", map.get("productList"));
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageInfo",map.get("pageInfo"));
        return "product/productManagement";
    }

    @GetMapping("/product/searchCategoryName")
    @ResponseBody
    public String searchCategoryName(@RequestParam("category_id") int category_id){
        return productCategoryService.searchCategoryName(category_id);
    }
}
