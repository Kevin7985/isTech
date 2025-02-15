package com.istech.users.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserDto {
    @NotNull(message = "Имя пользователя не может быть пустым")
    @Size(min = 1, max = 256, message = "Имя пользователя может быть от 1 до 256 символов")
    private final String username;

    @NotNull(message = "Пароль не может быть пустым")
    @Size(min = 10, max = 512, message = "Пароль может быть от 10 до 512 символов")
    private final String password;
}
