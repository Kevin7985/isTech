package com.istech.users;

import com.istech.service.MapperService;
import com.istech.users.dto.LoginCredentialsDto;
import com.istech.users.dto.LoginUserDto;
import com.istech.users.dto.NewUserDto;
import com.istech.users.dto.UserDto;
import com.istech.users.exceptions.UserNotFoundException;
import com.istech.users.models.User;
import com.istech.utils.StringGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final MapperService mapperService;
    private final UserRepository userRepository;
    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public UserDto createUser(NewUserDto userDto) {
        User user = mapperService.toUser(userDto);
        user = userRepository.save(user);
        return mapperService.toUserDto(user);
    }

    @Override
    public UserDto getUserByUserId(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с данным ID не найден"));
        return mapperService.toUserDto(user);
    }

    @Override
    public LoginCredentialsDto loginUser(LoginUserDto userDto) {
        User user = mapperService.toUser(userDto);
        user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())
                .orElseThrow(() -> new UserNotFoundException("Неверный логин или пароль"));

        String token = StringGenerator.generateToken();
        redisTemplate.opsForValue().set(token, user.getId().toString(), Duration.ofHours(2));

        return new LoginCredentialsDto(
                mapperService.toUserDto(user),
                token,
                2 * 3600L
        );
    }
}
