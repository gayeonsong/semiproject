package com.example.demo.controller.product;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;

@Controller
public class ProductImageUrlCotroller {
    private final String FILEPATH="C:\\web\\spring\\upload\\";

    @GetMapping("/product/showProductImage")
    @ResponseBody
    public UrlResource showProductImage(@RequestParam("image_path") String image_path) throws MalformedURLException {
        return new UrlResource("file:"+FILEPATH+image_path);
    }
}
