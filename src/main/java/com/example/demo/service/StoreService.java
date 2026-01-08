package com.example.demo.service;

import com.example.demo.dto.StoreDetailDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.dto.StoreListDto;
import com.example.demo.dto.StoreUpdateDto;
import com.example.demo.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreMapper storeMapper;

    public int StoreInsert(StoreDto dto) {
        return storeMapper.StoreInsert(dto);
    }

    public List<StoreListDto> ListStores() {
        List<StoreListDto> list=storeMapper.ListStores();
        return list;
    }

    public StoreDetailDto StoreDetail(int store_id) {
        return storeMapper.StoreDetail(store_id);
    }

    public StoreUpdateDto storeUpdateForm(int store_id) {
        return storeMapper.StoreUpdateForm(store_id);
    }

    public int StoreUpdate(StoreUpdateDto dto) {
        return storeMapper.StoreUpdate(dto);
    }

    public List<StoreListDto> searchStores(String keyword) {
        return storeMapper.searchStores(keyword);
    }

    public List<StoreListDto> filterStores(int status) {
        return storeMapper.filterStores(status);
    }

}
