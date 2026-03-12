package com.bridge.ecosystem.bridge_bank.mapper;

import com.bridge.ecosystem.bridge_bank.domain.User;
import com.bridge.ecosystem.bridge_bank.dto.user.UserRequestDTO;
import com.bridge.ecosystem.bridge_bank.dto.user.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

}