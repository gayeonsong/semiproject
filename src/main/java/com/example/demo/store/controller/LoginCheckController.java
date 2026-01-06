package com.example.demo.store.controller;

import com.example.demo.store.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LoginCheckController {
    private final LoginService loginService;
    @GetMapping("/login/check-id")
    @ResponseBody
    public boolean checkLoginId(@RequestParam String login_id) {
        return loginService.isIdAvailable(login_id);
    }
}
