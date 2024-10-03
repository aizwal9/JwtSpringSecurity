package com.service.auth.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;

    private String password;
}
