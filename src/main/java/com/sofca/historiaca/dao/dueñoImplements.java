package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.DuenoMapper;
import com.sofca.historiaca.mapper.MascotaMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

public class dueñoImplements implements CrudDao<DuenoDto> {
    public JdbcTemplate jdbcTemplate;
    public dueñoImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<DuenoDto> selectAll() throws DaoException {
        try{
            String SQL = "SELECT id_dueño,nombre_dueño,  apellido_dueño, telefono,num_identificacion, identificacion, id_ubicacion FROM  dueño";
            return jdbcTemplate.query(SQL, new DuenoMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public DuenoDto insert(DuenoDto duenoDto) throws DaoException {
        String INSERT = "INSERT INTO dueño (id_dueño, nombre_dueño, apellido_dueño, telefono, identificacion, id_ubicacion,num_identificacion)\n" +
                "VALUES ( ?, ?, ?, ?,?, ?,?,?)";
        try{
            jdbcTemplate.update(INSERT,
                    duenoDto.getId_Dueño(),
                    duenoDto.getNombreDueño(),
                    duenoDto.getApellidoDueño(),
                    duenoDto.getTelefono(),
                    duenoDto.getNum_identificacion(),
                    duenoDto.getTipoIdentificacionDto().getIdIdentificacion(),
                    duenoDto.getUbicacionDto().getIdUbicacion());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return duenoDto;
    }

    @Override
    public DuenoDto getId(UUID id) throws DaoException {
        String selectID ="SELECT   id_dueño,nombre_dueño,  apellido_dueño, telefono,num_identificacion, identificacion, id_ubicacion FROM  dueño where id_dueño=? ";
        try {
            return this.jdbcTemplate.queryForObject(selectID, new DuenoMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception exception){
            throw new DaoException(exception);
        }
    }

    @Override
    public void update(DuenoDto duenoDto) throws DaoException {
        String UPDATE=("UPDATE dueño  SET nombre_dueño=?, apellido_dueño=?, telefono=?, identificacion=?,id_ubicacion=?,num_identificacion=?   WHERE id_dueño=?");
        try {
            jdbcTemplate.update(UPDATE,
                    duenoDto.getId_Dueño(),
                    duenoDto.getNombreDueño(),
                    duenoDto.getApellidoDueño(),
                    duenoDto.getTelefono(),
                    duenoDto.getUbicacionDto().getIdUbicacion(),
                    duenoDto.getNum_identificacion(),
                    duenoDto.getTipoIdentificacionDto().getIdIdentificacion()
            );
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteId(UUID id) throws DaoException {
        DuenoDto duenoDto = new DuenoDto();
        String DELETE = "DELETE FROM dueño WHERE id_dueño=?";
        try {
            jdbcTemplate.update(DELETE, duenoDto.getId_Dueño() );

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
}

