package com.bridge.ecosystem.bridge_bank.service;

import com.bridge.ecosystem.bridge_bank.domain.User;
import com.bridge.ecosystem.bridge_bank.dto.user.UserRequestDTO;
import com.bridge.ecosystem.bridge_bank.dto.user.UserResponseDTO;
import com.bridge.ecosystem.bridge_bank.exceptions.ResourceNotFoundException;
import com.bridge.ecosystem.bridge_bank.mapper.UserMapper;
import com.bridge.ecosystem.bridge_bank.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {

        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    public UserResponseDTO getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        return userMapper.toResponseDTO(user);
    }

    public List<UserResponseDTO> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User updatedUser = userRepository.save(user);

        return userMapper.toResponseDTO(updatedUser);
    }

    public UserResponseDTO patchUser(Long id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null) {
            user.setPassword(dto.getPassword());
        }

        User updatedUser = userRepository.save(user);

        return userMapper.toResponseDTO(updatedUser);
    }
}