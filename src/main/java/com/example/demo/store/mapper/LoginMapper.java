package com.example.demo.store.mapper;

import com.example.demo.store.dto.LoginDto;
import com.example.demo.store.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    int LoginInsert(LoginDto dto);
    int countById(String login_id);
    int LoginUpdate(StoreUpdateDto dto);

}
