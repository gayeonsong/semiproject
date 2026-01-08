package com.example.demo.controller;

import com.example.demo.dto.StoreLoginDto;
import com.example.demo.dto.OwnerDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.service.StoreRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class InsertController {
    private final StoreRegisterService storeRegisterService;
    @GetMapping("/store/insert")
    public String insertForm() {
        return "store/insert";
    }

    @PostMapping("/store/insert")
    public String insert(StoreLoginDto storeLoginDto, StoreDto storeDto, OwnerDto ownerDto, Model model) {
        storeRegisterService.register(storeLoginDto,storeDto,ownerDto);
        model.addAttribute("msg","가맹점 등록이 완료되었습니다.");
        return "store/insert";
    }


}
