package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PacienteMapper implements RowMapper<PacienteDto> {
    @Override
    public PacienteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        PacienteDto pacienteDto = new PacienteDto();
        MascotaDto mascotaDto = new MascotaDto();
        DuenoDto duenoDto = new DuenoDto();
        duenoDto.setId_Dueño(UUID.fromString(rs.getString("id_dueño")));
        mascotaDto.setId_mascota(UUID.fromString(rs.getString("id_mascota")));
        mascotaDto.setNombre_mascota(rs.getString("nombre_mascota"));
        mascotaDto.setRaza(rs.getString("raza"));
        mascotaDto.setEspecie(rs.getString("especie"));
        mascotaDto.setFnac_mascota(rs.getDate("fnac_mascota").toLocalDate());
        mascotaDto.setDuenoDto(duenoDto);
        
        pacienteDto.setIdPaciente(UUID.fromString(rs.getString("id_paciente")));
        pacienteDto.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        pacienteDto.setMascotaDto(mascotaDto);
        return pacienteDto;
    }
}
