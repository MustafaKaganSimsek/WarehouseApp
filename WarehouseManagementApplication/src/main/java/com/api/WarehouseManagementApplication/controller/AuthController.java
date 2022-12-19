package com.api.WarehouseManagementApplication.controller;


import com.api.WarehouseManagementApplication.auth.JwtTokenProvider;
import com.api.WarehouseManagementApplication.dto.UserRequestDto;
import com.api.WarehouseManagementApplication.model.User;
import com.api.WarehouseManagementApplication.repository.UserRepository;
import com.api.WarehouseManagementApplication.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto userRequest){

        return  ResponseEntity.ok(userService.login(userRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequestDto registerRequest) {

        if (userService.register(registerRequest)) {
            return new ResponseEntity<>("User Succesfully registered", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
        }
    }
}
