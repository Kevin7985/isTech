package com.istech.users;

import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(NewUserDto userDto);
    UserDto getUserByUserId(UUID userId);
}
