package com.example.demo.store.mapper;

import com.example.demo.store.dto.OwnerDto;
import com.example.demo.store.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OwnerMapper {
    int OwnerInsert(OwnerDto dto);
    int OwnerUpdate(StoreUpdateDto dto);


}
