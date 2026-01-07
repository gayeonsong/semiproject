package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    //로그인처리
    @PostMapping("/login")
    public String login(
            @RequestParam("id") String loginId,
            @RequestParam("pwd") String password,
            HttpSession session,
            Model model) {
        //서비스에서 로그인 시도
        UserDTO loginUser = userService.login(loginId, password);

        //로그인 실패
        if (loginUser == null) {
            model.addAttribute("error", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login";
        }
        session.setAttribute("loginUser", loginUser);
        session.setAttribute("userId", loginUser.getUserId());
        session.setAttribute("loginId", loginUser.getLoginId());
        session.setAttribute("role", loginUser.getRole());
        if (loginUser.getRole() == 1) {
            return "redirect:/store";

        } else {
            return "redirect:/main";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}