package com.istech.users;

import com.istech.service.MapperService;
import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;
import com.istech.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final MapperService mapperService;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(NewUserDto userDto) {
        User user = mapperService.toUser(userDto);
        user = userRepository.save(user);
        return mapperService.toUserDto(user);
    }
}
