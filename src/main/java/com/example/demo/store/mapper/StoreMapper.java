package com.example.demo.store.mapper;

import com.example.demo.store.dto.StoreDetailDto;
import com.example.demo.store.dto.StoreDto;
import com.example.demo.store.dto.StoreListDto;
import com.example.demo.store.dto.StoreUpdateDto;
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
