package com.example.demo.store.controller;

import com.example.demo.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class StoreDetailController {
    private final StoreService  storeService;

    @GetMapping("/store/detail/{id}")
    public String StoreDetail(@PathVariable int id, Model model) {
        model.addAttribute("store",storeService.StoreDetail(id));
        return "store/detail";
    }
}
