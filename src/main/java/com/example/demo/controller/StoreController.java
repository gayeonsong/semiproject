package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class StoreController {

    @GetMapping("/store_test")
    public String store(Model model){
        return "board/store_test";
    }
}
