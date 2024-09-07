package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.PacienteDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class PacienteImplements implements CrudDao<PacienteDto> {
    public JdbcTemplate jdbcTemplate;
    public PacienteImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<PacienteDto> selectAll() throws DaoException {
        return null;
    }

    @Override
    public PacienteDto insert(PacienteDto pacienteDto) throws DaoException {
        return null;
    }

    @Override
    public PacienteDto getId(UUID id) throws DaoException {
        return null;
    }

    @Override
    public void update(PacienteDto pacienteDto) throws DaoException {

    }

    @Override
    public void deleteId(UUID id) throws DaoException {

    }
}
