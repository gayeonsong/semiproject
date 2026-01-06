package com.example.demo.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreListDto {
    private int store_id;
    private String store_name;
    private int store_status;
    private int commission_rate;
    private String owner_name;
}
