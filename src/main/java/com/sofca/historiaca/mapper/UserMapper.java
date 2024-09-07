package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper implements RowMapper<UserDto> {
    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId_user(UUID.fromString(rs.getString("id_user")));
        userDto.setNombre(rs.getString("nombre"));
        userDto.setCorreo(rs.getString("correo"));
        userDto.setPassword(rs.getString("password"));
        return userDto;
    }
}
