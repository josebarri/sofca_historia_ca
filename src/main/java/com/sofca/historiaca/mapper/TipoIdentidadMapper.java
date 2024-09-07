package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.TipoIdentificacionDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TipoIdentidadMapper implements RowMapper<TipoIdentificacionDto> {
    @Override
    public TipoIdentificacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        TipoIdentificacionDto tipoIdentificacionDto = new TipoIdentificacionDto();
        tipoIdentificacionDto.setIdIdentificacion(UUID.fromString(rs.getString("id_identificacion")));
        tipoIdentificacionDto.setTipo(rs.getString("tipo"));
        return tipoIdentificacionDto;
    }
}
