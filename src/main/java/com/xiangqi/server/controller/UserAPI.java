package com.xiangqi.server.controller;

import com.xiangqi.server.dto.UserDTO;
import com.xiangqi.server.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserAPI {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        if(userDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if(id == null || userDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        userService.updateUser(id, userDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        if(userDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.login(userDTO));
    }

}
