package com.istech.users;

import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;

public interface UserService {
    UserDto createUser(NewUserDto userDto);
}
