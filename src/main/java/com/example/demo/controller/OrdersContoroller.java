package com.example.demo.controller;

import com.example.demo.service.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OrdersContoroller {
    private final ProductListService productListService;

    @GetMapping("/branch/orders")
    public String productList(Model model) {
        model.addAttribute("list",productListService.productList());
        return "branch/orders";
    }



}
