package com.example.demo.controller;

import com.example.demo.service.StoreLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginCheckController {
    private final StoreLoginService storeLoginService;
    @GetMapping("/login/check-id")
    @ResponseBody
    public boolean checkLoginId(@RequestParam String login_id) {
        return storeLoginService.isIdAvailable(login_id);
    }
}
