package com.example.demo.mapper;


import com.example.demo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    //1.회원등록
    int insert(UserDTO dto);
    //2/로그인용 조회 (login_id로만 조회)
    UserDTO loginCheckByLoginId(String loginId);

}
