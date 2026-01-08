package com.example.demo.service;

import com.example.demo.dto.StoreLoginDto;
import com.example.demo.dto.StoreUpdateDto;
import com.example.demo.mapper.StoreLoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreLoginService {
    private final StoreLoginMapper storeLoginMapper;

    public int LoginInsert(StoreLoginDto dto) {
        return storeLoginMapper.LoginInsert(dto);
    }

    public boolean isIdAvailable(String login_id) {
        return storeLoginMapper.countById(login_id)==0;
    }

    public int LoginUpdate(StoreUpdateDto dto) {
        return storeLoginMapper.LoginUpdate(dto);
    }
}
