package com.istech.users.dto;

import com.istech.users.exceptions.exceptions.InternalServerErrorException;
import com.istech.users.models.User;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Component
public class UserMapper {
    public User toUser(NewUserDto userDto) {
        String password = userDto.getPassword();
        byte[] bytesOfMessage = null;
        byte[] theMD5digest = null;
        StringBuffer sb = null;

        try {
            bytesOfMessage = password.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            theMD5digest = md.digest(bytesOfMessage);

            sb = new StringBuffer();
            for (byte b : theMD5digest) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException("Encoding error");
        }

        return new User(
                null,
                userDto.getUsername(),
                sb.toString()
        );
    }

    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername()
        );
    }
}
