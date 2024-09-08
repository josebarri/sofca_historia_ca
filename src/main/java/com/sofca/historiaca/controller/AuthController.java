package com.sofca.historiaca.controller;

import com.sofca.historiaca.dto.UserDto;
import com.sofca.historiaca.security.JwtUtil;
import com.sofca.historiaca.services.UserService;
import com.sofca.historiaca.util.ResponseMessage;
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

    @PostMapping()
    public ResponseEntity<ResponseMessage> login(@RequestBody UserDto userDto) {
        Optional<UserDto> userFromDb = userService.getUserByCorreo(userDto.getCorreo());
        ResponseMessage message = null;

        if (userFromDb.isPresent() && userFromDb.get().getPassword().equals(userDto.getPassword())) {
            String token = jwtUtil.generateToken(userDto.getCorreo());
            message = new ResponseMessage<>(200, "Token Generado", token);
        } else {
            message = new ResponseMessage<>(401, "Credenciales incorrectas", null);;
        }
        return ResponseEntity.ok(message);
    }
}
