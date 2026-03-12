package com.bridge.ecosystem.bridge_bank.controller;
import com.bridge.ecosystem.bridge_bank.domain.User;
import com.bridge.ecosystem.bridge_bank.dto.user.UserRequestDTO;
import com.bridge.ecosystem.bridge_bank.dto.user.UserResponseDTO;
import com.bridge.ecosystem.bridge_bank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> patchUser(
            @PathVariable Long id,
            @RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(userService.patchUser(id, dto));
    }
}
