package com.example.demo.store.service;

import com.example.demo.store.dto.LoginDto;
import com.example.demo.store.dto.StoreUpdateDto;
import com.example.demo.store.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public int LoginInsert(LoginDto dto) {
        return loginMapper.LoginInsert(dto);
    }

    public boolean isIdAvailable(String login_id) {
        return loginMapper.countById(login_id)==0;
    }

    public int LoginUpdate(StoreUpdateDto dto) {
        return loginMapper.LoginUpdate(dto);
    }
}
