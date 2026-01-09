package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public UserDTO login(String loginId, String password) {
        UserDTO user = mapper.loginCheckByLoginId(loginId);

        System.out.println("조회된 사용자: " + user);
        if (user != null) {
            System.out.println("DB 비밀번호: " + user.getPassword());
            System.out.println("입력 비밀번호: " + password);
        }
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        user.setPassword(null);
        return user;
    }

}
