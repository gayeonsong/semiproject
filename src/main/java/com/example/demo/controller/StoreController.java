package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
public class StoreController {

    @GetMapping("/store")
    public String store(Model model){
        return "board/store";
    }
}
