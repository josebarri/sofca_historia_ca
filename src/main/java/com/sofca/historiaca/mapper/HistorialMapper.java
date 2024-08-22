package com.sofca.historiaca.mapper;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;
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
        EpsDto epsDto = new EpsDto();
        epsDto.setId_eps(rs.getString("id_eps"));
        epsDto.setNombre(rs.getString("nombre"));
        epsDto.setTelefono(rs.getString("telefono"));
        epsDto.setFecha(rs.getString("fecha"));
        epsDto.setDireccion(rs.getString("direccion"));
        historiaClinicaDto.setEpsDto(epsDto);

        return historiaClinicaDto;
    }
}
