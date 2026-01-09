package com.example.demo.controller.product;

import com.example.demo.dto.product.*;
import com.example.demo.service.product.ProductCategoryService;
import com.example.demo.service.product.ProductManagementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductInsertController {
    private final ProductCategoryService service;
    private final ProductManagementService productService;
    private final String UPLOADPATH="c:\\web\\spring\\upload\\";
    @Value("${openai.api.key}")
    private String apiKey;

    @GetMapping("/product/productInsert")
    public String product(Model model){
        List<ProductParentCategoryRequestDto> list=service.parentCategorySearch();
        model.addAttribute("parentCategoryList",list);
        model.addAttribute("productDto",new ProducRequestDto());
        return "product/productInsert";
    }

    @GetMapping("/product/productInfo/{barcode}")
    @ResponseBody
    public String getInfo(@PathVariable("barcode") String barcode){
        try {
            String url = "http://openapi.foodsafetykorea.go.kr/api" +
                    "/"+apiKey+"/I2570/json/1/1/BRCD_NO=" + barcode;
            System.out.println(url);
            RestTemplate restTemplate = new RestTemplate();
            ;
            String data = restTemplate.getForObject(url, String.class);
            return data;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "{}";
        }
    }

    @GetMapping("/product/barcodeExist")
    @ResponseBody
    public Boolean barcodeExist(@RequestParam("barcode") String barcode){
        Boolean result = false;
        try {
            int n = productService.barcodeExist(barcode);
            if (n > 0) {
                result = true;
            }
        }catch (Exception e){
            result= false;
        }
        return result;
    }

    @PostMapping("/product/insert")
    public String insert(@Valid @ModelAttribute("productDto") ProducRequestDto dto,
                         BindingResult bindingResult, Model model, RedirectAttributes msg) throws IOException {
        MultipartFile file=dto.getFile1();
        String tempImg=file.getOriginalFilename();
        if(tempImg==null || tempImg.isEmpty()) {
            model.addAttribute("parentCategoryList",service.parentCategorySearch());
            model.addAttribute("productDto",dto);
            return "product/productInsert";
        }
        if(bindingResult.hasErrors()){
            if(tempImg!=null && tempImg.contains(".")) {
                model.addAttribute("tempImg",tempImg);
            }
            model.addAttribute("parentCategoryList",service.parentCategorySearch());
            model.addAttribute("productDto",dto);
            return "product/productInsert";
        }

//        //파일이 없는 경우
//        if(file==null || file.isEmpty()){
//            model.addAttribute("err", "이미지를 업로드하세요.");
//            model.addAttribute("parentCategoryList",service.parentCategorySearch());
//            model.addAttribute("productDto",dto);
//            return "product/productInsert";
//        }

        //카테고리 아이디 구하기
        int categoryId=service.searchCategoryId(dto.getSubCategoryName());
        System.out.println(categoryId);

        //image저장하고 저장장소 꺼내오기
        String savefilename="";
        if(file!=null && !file.isEmpty()){
            String orgfilename=file.getOriginalFilename();
            String extname = orgfilename.substring(orgfilename.lastIndexOf("."));
            savefilename = UUID.randomUUID() + extname;
            File savefile = new File(UPLOADPATH + savefilename);
            file.transferTo(savefile);
        }

        //dto에 담아 insert하기(product, product_price)
        ProductManagementDto productDto=new ProductManagementDto(0,dto.getBarcode(),categoryId,dto.getProduct_name(),savefilename,dto.getSafety_stock(),dto.getHq_supply_price());
        int n=productService.insert(productDto);
        List<ProductParentCategoryRequestDto> list=service.parentCategorySearch();
        if(n>0){
            msg.addFlashAttribute("msg","상품 등록 완료!");
        }
        return "redirect:/product/productManagement";
    }
}
