package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.MascotaDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistorialMapper implements RowMapper<HistoriaClinicaDto> {
    @Override
    public HistoriaClinicaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        HistoriaClinicaDto historiaClinicaDto = new HistoriaClinicaDto();
        historiaClinicaDto.setId_historial(rs.getString("id_historial"));
        historiaClinicaDto.setFecha_creacion(rs.getString("fecha_creacion"));
        historiaClinicaDto.setNombre_medico(rs.getString("nombre_medico"));
        historiaClinicaDto.setApellido_medico(rs.getString("apellido_medico"));
        historiaClinicaDto.setEspecialidad_medico(rs.getString("especialidad_medico"));
        historiaClinicaDto.setNombre_paciente(rs.getString("nombre_paciente"));
        historiaClinicaDto.setApellido_paciente(rs.getString("apellido_paciente"));
        historiaClinicaDto.setCc_paciente(rs.getString("cc_paciente"));
        historiaClinicaDto.setFn_paciente(rs.getString("fn_paciente"));
        historiaClinicaDto.setGenero_paciente(rs.getString("genero_paciente"));
        historiaClinicaDto.setDireccion_paciente(rs.getString("direccion_paciente"));
        historiaClinicaDto.setCorreo_paciente(rs.getString("correo_paciente"));
        historiaClinicaDto.setTelefono_paciente(rs.getString("telefono_paciente"));
        historiaClinicaDto.setCorreo_paciente(rs.getString("correo_paciente"));
        historiaClinicaDto.setTratamiento(rs.getString("tratamiento"));
        historiaClinicaDto.setDiagnostico(rs.getString("diagnostico"));
        historiaClinicaDto.setObservaciones(rs.getString("observaciones"));
        MascotaDto mascotaDto = new MascotaDto();
        mascotaDto.setId_eps(rs.getString("id_eps"));
        mascotaDto.setNombre(rs.getString("nombre"));
        mascotaDto.setTelefono(rs.getString("telefono"));
        mascotaDto.setFecha(rs.getString("fecha"));
        mascotaDto.setDireccion(rs.getString("direccion"));
        historiaClinicaDto.setEpsDto(mascotaDto);

        return historiaClinicaDto;
    }
}
