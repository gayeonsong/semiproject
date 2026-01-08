package com.example.demo.controller.product;

import com.example.demo.dto.product.ProductCategoryRequestDto;
import com.example.demo.service.product.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryOptionController {
    private final ProductCategoryService service;

    @GetMapping("/product/childCategoryOption")
    @ResponseBody
    public List<ProductCategoryRequestDto> childCategory(@RequestParam("parentCategory") String parentCategory){
        List<ProductCategoryRequestDto> list=service.childCategorySearch(parentCategory);
        return list;
    }

    @GetMapping("/product/subCategoryOption")
    @ResponseBody
    public List<ProductCategoryRequestDto> subCategory(@RequestParam("childCategory") String childCategory){
        List<ProductCategoryRequestDto> list=service.subCategorySearch(childCategory);
        return list;
    }
}
