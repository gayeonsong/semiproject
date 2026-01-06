package com.example.demo.store.controller;

import com.example.demo.store.dto.LoginDto;
import com.example.demo.store.dto.OwnerDto;
import com.example.demo.store.dto.StoreDto;
import com.example.demo.store.service.LoginService;
import com.example.demo.store.service.OwnerService;
import com.example.demo.store.service.StoreRegisterService;
import com.example.demo.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class InsertController {
    private final StoreRegisterService storeRegisterService;
    @GetMapping("/store/insert")
    public String insertForm() {
        return "store/insert";
    }

    @PostMapping("/store/insert")
    public String insert(LoginDto loginDto, StoreDto storeDto, OwnerDto ownerDto, Model model) {
        storeRegisterService.register(loginDto,storeDto,ownerDto);
        model.addAttribute("msg","가맹점 등록이 완료되었습니다.");
        return "store/insert";
    }


}
