package com.example.demo.mapper;

import com.example.demo.dto.DiscardDTO;
import com.example.demo.dto.DiscardListDTO;

public interface DiscardMapper {
    int insertDiscard(DiscardListDTO dto);
    int deleteDiscard(int discardId);
}
