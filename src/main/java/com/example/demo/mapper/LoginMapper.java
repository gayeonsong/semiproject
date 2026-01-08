package com.example.demo.mapper;

import com.example.demo.dto.LoginDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface LoginMapper {
    LoginDto login(Map<String, Object> map);

}
