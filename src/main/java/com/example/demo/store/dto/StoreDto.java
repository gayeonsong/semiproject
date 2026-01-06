package com.example.demo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreDto {
    private int store_id;
    private String store_name;
    private int store_status;
    private int commission_rate;
}
