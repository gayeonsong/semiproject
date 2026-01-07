package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/main")
    public String main(Model model){
          return "board/main";
    }
}
