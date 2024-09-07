package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.dto.UbicacionDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MascotaMapper implements RowMapper<MascotaDto> {

    @Override
    public MascotaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        MascotaDto mascotaDto = new MascotaDto();
        DuenoDto duenoDto = new DuenoDto();
        TipoIdentificacionDto tipoIdentificacionDto = new TipoIdentificacionDto();
        UbicacionDto ubicacionDto = new UbicacionDto();

        ubicacionDto.setIdUbicacion(UUID.fromString(rs.getString("id_ubicacion")));
        tipoIdentificacionDto.setIdIdentificacion(UUID.fromString(rs.getString("identificacion")));

        duenoDto.setId_Dueño(UUID.fromString(rs.getString("id_dueño")));
        duenoDto.setNombreDueño(rs.getString("nombre_dueño"));
        duenoDto.setApellidoDueño(rs.getString("apellido_dueño"));
        duenoDto.setNum_identificacion(rs.getString("Num_identificacion"));
        duenoDto.setTelefono(rs.getString("telefono"));
        duenoDto.setTipoIdentificacionDto(tipoIdentificacionDto);
        duenoDto.setUbicacionDto(ubicacionDto);

        mascotaDto.setId_mascota(UUID.fromString(rs.getString("id_mascota")));
        mascotaDto.setFnac_mascota(rs.getDate("fnac_mascota").toLocalDate());
        mascotaDto.setNombre_mascota(rs.getString("nombre_mascota"));
        mascotaDto.setRaza(rs.getString("raza"));
        mascotaDto.setEspecie(rs.getString("especie"));
        mascotaDto.setDuenoDto(duenoDto);
        return mascotaDto;
    }
}
