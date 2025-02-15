package com.istech.users;

import com.istech.users.dto.LoginCredentialsDto;
import com.istech.users.dto.LoginUserDto;
import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Методы для работы с данными пользователя")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping
    @Operation(summary = "Создание нового пользователя")
    public UserDto createUser(@RequestBody NewUserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Получение профиля пользователя по userId")
    public UserDto getUserByUserId(@PathVariable UUID userId) {
        return userService.getUserByUserId(userId);
    }

    @PostMapping("/login")
    @Operation(summary = "Вход в профиль пользователя")
    public LoginCredentialsDto loginUser(@RequestBody LoginUserDto userDto) {
        return userService.loginUser(userDto);
    }
}
