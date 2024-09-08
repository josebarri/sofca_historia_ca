package com.sofca.historiaca.repositories;

import com.sofca.historiaca.dto.UserDto;
import com.sofca.historiaca.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<UserDto> findByCorreo(String correo) {
        String sql = "SELECT * FROM user WHERE correo = ?";

        try {
            UserDto user = jdbcTemplate.queryForObject(sql, new Object[]{correo}, new UserMapper());
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
