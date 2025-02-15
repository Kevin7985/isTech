package com.istech.service;

import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;
import com.istech.users.dto.UserMapper;
import com.istech.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperService {
    private final UserMapper userMapper;

    public User toUser(NewUserDto userDto) {
        return userMapper.toUser(userDto);
    }

    public UserDto toUserDto(User user) {
        return userMapper.toUserDto(user);
    }
}
