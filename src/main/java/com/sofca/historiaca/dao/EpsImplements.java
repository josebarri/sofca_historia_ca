package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.EpsMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class EpsImplements implements EpsDaoInterface {
public JdbcTemplate jdbcTemplate;
public EpsImplements (DataSource dataSource){
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}
    @Override
    public List<Map<String, Object>> selectAll()   throws DaoException{
        try{
            String SQL = "SELECT * FROM EPS";
            return jdbcTemplate.queryForList(SQL);
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public void InsertEps(EpsDto epsDto)  throws DaoException {
        String INSERT = "INSERT INTO eps(nombre, direccion, fecha, telefono, id_eps) VALUES ( ?, ?, ?, ?,?)";
        try{
            jdbcTemplate.update(INSERT,
                    epsDto.getNombre(),
                    epsDto.getDireccion(),
                    epsDto.getFecha(),
                    epsDto.getTelefono(),
                    epsDto.getId_eps());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return;
    }

    @Override
    public void EditEps(EpsDto epsDto) throws DaoException{
       String UPDATE=("UPDATE eps  SET nombre=?, direccion=?, fecha=?, telefono=? WHERE id_eps=?");
        try {
            jdbcTemplate.update(UPDATE,
                    epsDto.getNombre(),
                    epsDto.getDireccion(),
                    epsDto.getFecha(),
                    epsDto.getTelefono(),
                    epsDto.getId_eps());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
       return;
    }

    @Override
    public void DeleteEps(EpsDto epsDto) throws DaoException{
      String DELETE = "DELETE FROM eps WHERE id_eps=?";
        try {
          jdbcTemplate.update(DELETE, epsDto.getId_eps());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public EpsDto EpsID(EpsDto epsDto){
         try {
             String QUERY = "SELECT id_eps,nombre, direccion, fecha, telefono FROM eps WHERE id_eps=?";
             return jdbcTemplate.queryForObject(QUERY, new EpsMapper(),epsDto.getId_eps());

         }catch (EmptyResultDataAccessException ex){
             return null;
         }
     }
}
