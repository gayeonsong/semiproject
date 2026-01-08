package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StoreUpdateDto {
    private Integer store_id;
    private String store_name;
    private Integer store_status;
    private Double commission_rate;
    private Integer owner_id;
    private String owner_name;
    private String owner_phone;
    private Integer user_id;
    private String login_id;
    private String password;
}
