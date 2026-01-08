package com.example.demo.service;

import com.example.demo.dto.OwnerDto;
import com.example.demo.dto.StoreUpdateDto;
import com.example.demo.mapper.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerMapper ownerMapper;

    public int OwnerInsert(OwnerDto dto) {
        return ownerMapper.OwnerInsert(dto);
    }

    public int OwnerUpdate(StoreUpdateDto dto) {
        return ownerMapper.OwnerUpdate(dto);
    }


}
