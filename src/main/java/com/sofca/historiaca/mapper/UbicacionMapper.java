package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.UbicacionDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UbicacionMapper implements RowMapper<UbicacionDto> {
    @Override
    public UbicacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UbicacionDto ubicacionDto = new UbicacionDto();
        ubicacionDto.setIdUbicacion(UUID.fromString(rs.getString("id_ubicacion")));
        ubicacionDto.setCiudad(rs.getString("ciudad"));
        ubicacionDto.setDireccion(rs.getString("direccion"));
        return ubicacionDto;
    }
}
