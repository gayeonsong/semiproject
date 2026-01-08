package com.example.demo.mapper;

import com.example.demo.dto.StoreLoginDto;
import com.example.demo.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreLoginMapper {
    int LoginInsert(StoreLoginDto dto);
    int countById(String login_id);
    int LoginUpdate(StoreUpdateDto dto);

}
