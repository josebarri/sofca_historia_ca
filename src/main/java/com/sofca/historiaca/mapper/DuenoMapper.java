package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.dto.UbicacionDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DuenoMapper implements RowMapper<DuenoDto> {
    @Override
    public DuenoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        DuenoDto duenoDto = new DuenoDto();
        TipoIdentificacionDto tipoIdentificacionDto = new TipoIdentificacionDto();

        UbicacionDto ubicacionDto = new UbicacionDto();
        tipoIdentificacionDto.setIdIdentificacion(UUID.fromString(rs.getString("id_identificacion")));
        ubicacionDto.setIdUbicacion(UUID.fromString(rs.getString("id_ubicacion")));

        duenoDto.setId_Dueño(UUID.fromString(rs.getString("id_dueño")));
        duenoDto.setNombreDueño(rs.getString("nombre_dueño"));
        duenoDto.setApellidoDueño(rs.getString("apellido_dueño"));
        duenoDto.setTelefono(rs.getString("telefono"));
        duenoDto.setNum_identificacion(rs.getString("num_identificacion"));
        duenoDto.setTipoIdentificacionDto(tipoIdentificacionDto);
        duenoDto.setUbicacionDto(ubicacionDto);

        return duenoDto;
    }
}
