package com.example.demo.mapper;

import com.example.demo.dto.OwnerDto;
import com.example.demo.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OwnerMapper {
    int OwnerInsert(OwnerDto dto);
    int OwnerUpdate(StoreUpdateDto dto);


}
