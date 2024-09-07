package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.DuenoMapper;
import com.sofca.historiaca.mapper.MascotaMapper;
import com.sofca.historiaca.mapper.PacienteMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;
@Repository
public class PacienteImplements implements CrudDao<PacienteDto> {
    public JdbcTemplate jdbcTemplate;
    public PacienteImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<PacienteDto> selectAll() throws DaoException {
        try{
            String SQL = "SELECT p.id_paciente,  p.fecha_registro, m.id_mascota, m.nombre_mascota,m.fnac_mascota, m.raza,m.especie, m.id_dueno, d.nombre_dueno,d.num_identificacion FROM paciente p INNER JOIN mascota m ON p.id_mascota = m.id_mascota INNER JOIN dueno d ON m.id_dueno = d.id_dueno;";
            return jdbcTemplate.query(SQL, new PacienteMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public PacienteDto insert(PacienteDto pacienteDto) throws DaoException {
        String INSERT = "INSERT INTO paciente ( id_mascota) VALUES ( ?)";
        try{
            jdbcTemplate.update(INSERT,
                    pacienteDto.getMascotaDto().getId_mascota());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return pacienteDto;
    }

    @Override
    public PacienteDto getId(UUID id) throws DaoException {
        String selectID ="SELECT p.id_paciente,  p.fecha_registro, m.id_mascota, m.nombre_mascota,m.fnac_mascota, m.raza,m.especie, m.id_dueno, d.nombre_dueno,d.num_identificacion FROM paciente p INNER JOIN mascota m ON p.id_mascota = m.id_mascota INNER JOIN dueno d ON m.id_dueno = d.id_dueno where p.id_paciente= ?";
        try {
            return this.jdbcTemplate.queryForObject(selectID, new PacienteMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception exception){
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(PacienteDto pacienteDto) throws DaoException {
        String UPDATE=("UPDATE paciente  SET id_mascota=?  WHERE id_paciente=?");
        try {
            jdbcTemplate.update(UPDATE,
                    pacienteDto.getMascotaDto().getId_mascota(),
                    pacienteDto.getIdPaciente()


            );
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteId(UUID id) throws DaoException {
        String DELETE = "DELETE FROM paciente WHERE id_paciente=?";
        try {
            jdbcTemplate.update(DELETE, id);

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
    }

