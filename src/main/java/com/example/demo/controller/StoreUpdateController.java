package com.example.demo.controller;

import com.example.demo.dto.StoreUpdateDto;
import com.example.demo.service.StoreRegisterService;
import com.example.demo.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class StoreUpdateController {
    private final StoreService storeService;
    private final StoreRegisterService storeRegisterService;

    @GetMapping("/store/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("store",storeService.storeUpdateForm(id));
        return "store/update";
    }
    @PostMapping("/store/update")
    public String update(StoreUpdateDto dto, RedirectAttributes ra) {
        storeRegisterService.Update(dto);
        ra.addFlashAttribute("msg","가맹점 수정이 완료되었습니다.");
        return "redirect:/store/update/"+dto.getStore_id();
    }



}
