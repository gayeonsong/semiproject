package com.example.demo.service;

import com.example.demo.dto.StoreLoginDto;
import com.example.demo.dto.OwnerDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.dto.StoreUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StoreRegisterService {
    private final StoreLoginService storeLoginService;
    private final StoreService storeService;
    private final OwnerService ownerService;
    @Transactional
    public void register(StoreLoginDto storeLoginDto, StoreDto storeDto, OwnerDto ownerDto) {
        storeLoginService.LoginInsert(storeLoginDto);
        storeService.StoreInsert(storeDto);

        ownerDto.setUser_id(storeLoginDto.getUser_id());
        ownerDto.setStore_id(storeDto.getStore_id());

        ownerService.OwnerInsert(ownerDto);
    }
    @Transactional
    public void Update(StoreUpdateDto dto) {

        if(dto.getPassword() !=null && !dto.getPassword().isBlank()) {
            storeLoginService.LoginUpdate(dto);
        }
        ownerService.OwnerUpdate(dto);
        storeService.StoreUpdate(dto);
    }
}
