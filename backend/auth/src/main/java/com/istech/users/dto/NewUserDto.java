package com.istech.users.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewUserDto {
    @NotNull
    @Size(min = 1, max =  256)

    private final String username;

    @NotNull
    @Size(min = 10, max = 512)
    private final String password;
}
