package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;
import com.sofca.historiaca.mapper.EpsMapper;
import com.sofca.historiaca.mapper.HistorialMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class HistoCliImplements implements HistoCliDaoInterface{
    public JdbcTemplate jdbcTemplate;

    public HistoCliImplements(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Map<String, Object>> selectAll() {
        String SQL = "SELECT id_historial, cc_paciente, nombre_paciente, apellido_paciente, genero_paciente, direccion_paciente, telefono_paciente, correo_paciente, nombre_medico, apellido_medico, especialidad_medico, diagnostico, tratamiento, fecha_creacion, observaciones, id_eps, fn_paciente\n" +
                "\tFROM historial_clinico";
        return this.jdbcTemplate.queryForList(SQL);
    }

    @Override
    public void InsertHisto(HistoriaClinicaDto historiaClinicaDto) {
   String Isert = "INSERT INTO historial_clinico(id_historial,cc_paciente, nombre_paciente, apellido_paciente, genero_paciente, direccion_paciente, telefono_paciente, correo_paciente, nombre_medico, apellido_medico, especialidad_medico, diagnostico, tratamiento, fecha_creacion, observaciones, id_eps, fn_paciente)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
 this.jdbcTemplate.update(Isert,
        historiaClinicaDto.getId_historial(),
        historiaClinicaDto.getCc_paciente(),
        historiaClinicaDto.getNombre_paciente(),
        historiaClinicaDto.getApellido_paciente(),
        historiaClinicaDto.getGenero_paciente(),
        historiaClinicaDto.getDireccion_paciente(),
        historiaClinicaDto.getTelefono_paciente(),
        historiaClinicaDto.getCorreo_paciente(),
        historiaClinicaDto.getNombre_medico(),
        historiaClinicaDto.getApellido_medico(),
        historiaClinicaDto.getEspecialidad_medico(),
        historiaClinicaDto.getDiagnostico(),
        historiaClinicaDto.getTratamiento(),
        historiaClinicaDto.getFecha_creacion(),
        historiaClinicaDto.getObservaciones(),
        historiaClinicaDto.getEpsDto().getId_eps(),
        historiaClinicaDto.getFn_paciente());
    }

    @Override
    public void EditHisto(HistoriaClinicaDto historiaClinicaDto) {
        String Update = "UPDATE public.historial_clinico\n" +
                "\tSET id_historial=?, cc_paciente=?, nombre_paciente=?, apellido_paciente=?, genero_paciente=?, direccion_paciente=?, telefono_paciente=?, correo_paciente=?, nombre_medico=?, apellido_medico=?, especialidad_medico=?, diagnostico=?, tratamiento=?, fecha_creacion=?, observaciones=?, id_eps=?, fn_paciente=?\n" +
                "\tWHERE id_historial=?";
        jdbcTemplate.update(Update,
                historiaClinicaDto.getId_historial(),
                historiaClinicaDto.getCc_paciente(),
                historiaClinicaDto.getNombre_paciente(),
                historiaClinicaDto.getApellido_paciente(),
                historiaClinicaDto.getGenero_paciente(),
                historiaClinicaDto.getDireccion_paciente(),
                historiaClinicaDto.getTelefono_paciente(),
                historiaClinicaDto.getCorreo_paciente(),
                historiaClinicaDto.getNombre_medico(),
                historiaClinicaDto.getApellido_medico(),
                historiaClinicaDto.getEspecialidad_medico(),
                historiaClinicaDto.getDiagnostico(),
                historiaClinicaDto.getTratamiento(),
                historiaClinicaDto.getFecha_creacion(),
                historiaClinicaDto.getObservaciones(),
                historiaClinicaDto.getEpsDto().getId_eps(),
                historiaClinicaDto.getFn_paciente());

    }

    @Override
    public void DeleteHisto(HistoriaClinicaDto historiaClinicaDto) {
        String DELETE = "DELETE FROM historial_clinico\n" +
                "\tWHERE id_historial;";
        jdbcTemplate.update(DELETE, historiaClinicaDto.getId_historial());
    }

    @Override
    public HistoriaClinicaDto histoclinicabyid(HistoriaClinicaDto historiaClinicaDto) {
        try {
            String QUERY ="SELECT  h.id_historial,  h.cc_paciente," +
                    "   h.nombre_paciente,   h.apellido_paciente,  h.genero_paciente, " +
                    "  h.direccion_paciente,  h.telefono_paciente,   h.correo_paciente,  h.nombre_medico, " +
                    " h.apellido_medico,  h.especialidad_medico, h.diagnostico,  h.tratamiento," +
                    "   h.fecha_creacion, h.observaciones, e.id_eps, " +
                    " e.nombre AS nombre_eps, e.direccion AS direccion_eps, " +
                    "e.telefono AS telefono_eps, h.fn_paciente FROM  historial_clinico h INNER JOIN " +
                    "   eps e ON h.id_eps = e.id_eps WHERE id_historial=?";
            return jdbcTemplate.queryForObject(QUERY, new HistorialMapper(),historiaClinicaDto.getId_historial());

        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

}
