package com.sofca.historiaca.services;

import com.sofca.historiaca.dto.UserDto;
import com.sofca.historiaca.repositories.UserJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserJdbcRepository userJdbcRepository;

    // Método para obtener el usuario por correo
    public Optional<UserDto> getUserByCorreo(String correo) {
        return userJdbcRepository.findByCorreo(correo);
    }
}
