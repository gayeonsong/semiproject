package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Integer userId;

    @NotBlank(message = "아이디를 필수입력사항입니다.")
    @Size(min=5,max=10)
    private String loginId;

    @NotBlank(message = "비밀번호는 필수 입력상황입니다.")
    private String password;

    private Integer role;



}
