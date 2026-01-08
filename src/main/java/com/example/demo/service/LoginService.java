package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginMapper loginMapper;

    public LoginDto login(Map<String, Object> map) {
        return loginMapper.login(map);
    }

}
