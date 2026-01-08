package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreDetailDto {
    private int store_id;
    private String store_name;
    private int store_status;
    private double commission_rate;
    private String owner_name;
    private String owner_phone;
}
