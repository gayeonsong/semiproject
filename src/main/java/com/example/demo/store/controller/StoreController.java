package com.example.demo.store.controller;

import com.example.demo.store.dto.StoreListDto;
import com.example.demo.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/store")
    public String storeForm(Model model) {
        List<StoreListDto> list=storeService.ListStores();
        model.addAttribute("list",list);
        return "store/store";
    }
    @GetMapping("/store/search")
    @ResponseBody
    public List<StoreListDto> searchStores(@RequestParam String keyword) {
        return storeService.searchStores(keyword);
    }
    @GetMapping("/store/filter")
    @ResponseBody
    public List<StoreListDto> filterStores(@RequestParam String status) {
        if(status.equals("all")) {
            return storeService.ListStores();
        }else {
            int s=Integer.parseInt(status);
            return storeService.filterStores(s);
        }
    }




}
