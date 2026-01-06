package com.example.demo.store.service;

import com.example.demo.store.dto.LoginDto;
import com.example.demo.store.dto.OwnerDto;
import com.example.demo.store.dto.StoreDto;
import com.example.demo.store.dto.StoreUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreRegisterService {
    private final LoginService loginService;
    private final StoreService storeService;
    private final OwnerService ownerService;
    @Transactional
    public void register(LoginDto loginDto, StoreDto storeDto, OwnerDto ownerDto) {
        loginService.LoginInsert(loginDto);
        storeService.StoreInsert(storeDto);

        ownerDto.setUser_id(loginDto.getUser_id());
        ownerDto.setStore_id(storeDto.getStore_id());

        ownerService.OwnerInsert(ownerDto);
    }
    @Transactional
    public void Update(StoreUpdateDto dto) {

        if(dto.getPassword() !=null && !dto.getPassword().isBlank()) {
            loginService.LoginUpdate(dto);
        }
        ownerService.OwnerUpdate(dto);
        storeService.StoreUpdate(dto);
    }
}
