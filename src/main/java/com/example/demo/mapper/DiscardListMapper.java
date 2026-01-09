package com.example.demo.mapper;

import com.example.demo.dto.DiscardListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.util.Map;
@Mapper
public interface DiscardListMapper {
    int insertDiscard(DiscardListDTO dto);
    int updateDiscard(DiscardListDTO dto);
    List<DiscardListDTO> selectList(Map<String,Object>map);
    DiscardListDTO discardId(int num);
    DiscardListDTO batchId(int num);
    DiscardListDTO discardQty(int num);
    DiscardListDTO discardDate(String date);

}
