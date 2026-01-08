package com.example.demo.controller.product;

import com.example.demo.dto.product.ProductManagementDto;
import com.example.demo.dto.product.ProductManagementListDto;
import com.example.demo.dto.product.ProductParentCategoryRequestDto;
import com.example.demo.dto.product.ProductUpdateRequestDto;
import com.example.demo.service.product.ProductCategoryService;
import com.example.demo.service.product.ProductManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductUpdateController {
    private final ProductManagementService service;
    private final ProductCategoryService productCategoryService;
    private final String FILEPATH="C:\\web\\spring\\upload\\";

    @GetMapping("/product/productUpdateForm")
    public String updateInfo(@RequestParam("product_id") int product_id, Model model){
        ProductManagementListDto dto=service.selectItem(product_id);
        List<ProductParentCategoryRequestDto> parentCategoryList=productCategoryService.parentCategorySearch();
        model.addAttribute("productDto",dto);
        model.addAttribute("parentCategoryList",parentCategoryList);
        return "product/productUpdateForm";
    }

    @PostMapping("/product/productInfoUpdate")
    public String productupdateInfo(ProductUpdateRequestDto dto, RedirectAttributes result) throws IOException {
        MultipartFile newFile=dto.getNewImgFile();
        String saveImgPath=null;
        if(!newFile.isEmpty()){
            //기존파일 삭제
            File ordFile=new File(FILEPATH+dto.getImage_path());
            ordFile.delete();
            //새 파일 저장
            String originalName=newFile.getOriginalFilename();
            String newFileUrl= UUID.randomUUID()+originalName.substring(originalName.lastIndexOf("."));
            File newFilePath=new File(FILEPATH+newFileUrl);
            newFile.transferTo(newFilePath);
            saveImgPath=newFileUrl;
        }

        //카테고리 id 불러오기
        int category_id=productCategoryService.searchCategoryId(dto.getSubCategory());

        //업데이트
        int n=service.updateProductInfo(new ProductManagementDto(dto.getProduct_id(),null,category_id,null,saveImgPath,dto.getSafety_stock(),dto.getHq_supply_price()));
        String r=(n>0)?"success":"failure";
        result.addFlashAttribute("result",r);
        return "redirect:/product/productManagement";
    }
}
