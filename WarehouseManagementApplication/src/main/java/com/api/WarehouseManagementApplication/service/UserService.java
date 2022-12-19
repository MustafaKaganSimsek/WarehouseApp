package com.api.WarehouseManagementApplication.service;

import com.api.WarehouseManagementApplication.auth.CustomUserDetails;
import com.api.WarehouseManagementApplication.auth.JwtTokenProvider;
import com.api.WarehouseManagementApplication.dto.UserDto;
import com.api.WarehouseManagementApplication.dto.UserRequestDto;
import com.api.WarehouseManagementApplication.dto.mapper.UserDtoConverter;
import com.api.WarehouseManagementApplication.model.User;
import com.api.WarehouseManagementApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final UserDtoConverter converter;


    public UserDto createUser(User user){
        return converter.convert(userRepository.save(user));
    }

    public List<UserDto> findAllUser(){
        return converter.convert(
                userRepository.findAll()
        );
    }

    public User findByIdUserEntity(Long id){
        Optional<User> user=userRepository.findById(id);
        return user.isPresent()?user.get():null;
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public String login(UserRequestDto userRequestDto){
        UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(userRequestDto.getEmail(),userRequestDto.getPassword());
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return  jwtToken;
    }
    public boolean register(UserRequestDto registerRequest){
        try {
            User user = new User();
            user.setRole("user");
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            converter.convert(userRepository.save(user));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }
}
