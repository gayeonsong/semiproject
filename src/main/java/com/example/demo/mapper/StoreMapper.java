package com.example.demo.mapper;

import com.example.demo.dto.StoreDetailDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.dto.StoreListDto;
import com.example.demo.dto.StoreUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    int StoreInsert(StoreDto dto);
    List<StoreListDto> ListStores();
    StoreDetailDto StoreDetail(int store_id);
    StoreUpdateDto StoreUpdateForm(int store_id);
    int StoreUpdate(StoreUpdateDto dto);
    List<StoreListDto> searchStores(String keyword);
    List<StoreListDto> filterStores(int status);
}
