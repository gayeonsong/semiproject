package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiscardListDTO {

    private int discardId;
    private int batchId;
    private int discardQty;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date discardDate;

}


