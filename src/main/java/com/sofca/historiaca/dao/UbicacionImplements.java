package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.UbicacionDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.TipoIdentidadMapper;
import com.sofca.historiaca.mapper.UbicacionMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;
@Repository
public class UbicacionImplements implements CrudDao<UbicacionDto> {
    public JdbcTemplate jdbcTemplate;
    public UbicacionImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<UbicacionDto> selectAll() throws DaoException {
        try{
            String SQL = "SELECT id_ubicacion, ciudad,direccion FROM ubicacion";
            return jdbcTemplate.query(SQL, new UbicacionMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public UbicacionDto insert(UbicacionDto ubicacionDto) throws DaoException {
        String INSERT = "INSERT INTO ubicacion (id_ubicacion, ciudad, direccion) VALUES ( ?, ?,?)";
        try{
            jdbcTemplate.update(INSERT,
                    ubicacionDto.getIdUbicacion(),
                    ubicacionDto.getCiudad(),
                    ubicacionDto.getDireccion());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return ubicacionDto;
    }

    @Override
    public UbicacionDto getId(UUID id) throws DaoException {
        String selectID ="SELECT  id_ubicacion, ciudad, direccion from ubicacion where id_ubicacion= ?";
        try {
            return this.jdbcTemplate.queryForObject(selectID, new UbicacionMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception exception){
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(UbicacionDto ubicacionDto) throws DaoException {
        String UPDATE="UPDATE ubicacion  SET ciudad=?, direccion=? WHERE id_ubicacion=?";
        try {
            jdbcTemplate.update(UPDATE,
                    ubicacionDto.getIdUbicacion(),
                    ubicacionDto.getDireccion(),
                    ubicacionDto.getCiudad());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteId(UUID id) throws DaoException {

        String DELETE = "DELETE FROM ubicacion WHERE id_ubicacion=";
        try {
            jdbcTemplate.update(DELETE, id);

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
}
