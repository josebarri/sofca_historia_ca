package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.EpsDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EpsMapper implements RowMapper<EpsDto> {

    @Override
    public EpsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        EpsDto eps = new EpsDto();
        eps.setNombre(rs.getString("nombre"));
        eps.setDireccion(rs.getString("direccion"));
        eps.setFecha(rs.getString("fecha"));
        eps.setTelefono(rs.getString("telefono"));
        eps.setId_eps(rs.getString("id_eps"));
        return eps;
    }
}
