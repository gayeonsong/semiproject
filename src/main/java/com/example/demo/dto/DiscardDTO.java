package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiscardDTO {

    private String productName;
    private String categoryName;
    private int hqQuantity;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date inboundDate;

}
