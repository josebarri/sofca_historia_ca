package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.MascotaMapper;
import com.sofca.historiaca.mapper.TipoIdentidadMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class TipoIdentificacionImplements implements CrudDao<TipoIdentificacionDto> {
    public JdbcTemplate jdbcTemplate;
    public TipoIdentificacionImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<TipoIdentificacionDto> selectAll() throws DaoException {
        try{
            String SQL = "SELECT id_identificacion, tipo FROM tipo_identificacion;";
            return jdbcTemplate.query(SQL, new TipoIdentidadMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public TipoIdentificacionDto insert(TipoIdentificacionDto tipoIdentificacionDto) throws DaoException {
        String INSERT = "INSERT INTO tipo_identificacion (id_identificacion, tipo) VALUES ( ?, ?)";
        try{
            jdbcTemplate.update(INSERT,
                    tipoIdentificacionDto.getIdIdentificacion(),
                    tipoIdentificacionDto.getTipo());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return tipoIdentificacionDto;

    }

    @Override
    public TipoIdentificacionDto getId(UUID id) throws DaoException {
        String selectID ="SELECT  id_identificacion, tipo, from tipo_identificacion where id_identificacion= ?";
        try {
            return this.jdbcTemplate.queryForObject(selectID, new TipoIdentidadMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception exception){
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(TipoIdentificacionDto tipoIdentificacionDto) throws DaoException {
        String UPDATE=("UPDATE tipo_identificacion  SET tipo=? WHERE tipo_identificacion=?");
        try {
            jdbcTemplate.update(UPDATE,
                    tipoIdentificacionDto.getTipo(),
                    tipoIdentificacionDto.getIdIdentificacion()

            );
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
        return;
    }

    @Override
    public void deleteId(UUID id) throws DaoException {
        TipoIdentificacionDto tipoIdentificacionDto = new TipoIdentificacionDto();
        String DELETE = "DELETE FROM tipo_identificacion WHERE id_identificacion=?";
        try {
            jdbcTemplate.update(DELETE, tipoIdentificacionDto.getIdIdentificacion() );

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
}
