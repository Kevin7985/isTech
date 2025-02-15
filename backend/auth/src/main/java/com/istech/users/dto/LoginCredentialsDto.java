package com.istech.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginCredentialsDto {
    private final UserDto user;
    private final String token;
    private final Long expires;
}
