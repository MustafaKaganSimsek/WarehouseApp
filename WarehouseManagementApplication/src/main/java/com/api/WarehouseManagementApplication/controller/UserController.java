package com.api.WarehouseManagementApplication.controller;

import com.api.WarehouseManagementApplication.auth.CustomUserDetails;
import com.api.WarehouseManagementApplication.dto.UserDto;
import com.api.WarehouseManagementApplication.model.User;
import com.api.WarehouseManagementApplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/s")
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }
}
