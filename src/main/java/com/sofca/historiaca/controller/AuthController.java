package com.sofca.historiaca.controller;

import com.sofca.historiaca.dto.UserDto;
import com.sofca.historiaca.security.JwtUtil;
import com.sofca.historiaca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        Optional<UserDto> userFromDb = userService.getUserByCorreo(userDto.getCorreo());

        if (userFromDb.isPresent() && userFromDb.get().getPassword().equals(userDto.getPassword())) {
            String token = jwtUtil.generateToken(userDto.getCorreo());
            return ResponseEntity.ok().body("Bearer " + token);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
