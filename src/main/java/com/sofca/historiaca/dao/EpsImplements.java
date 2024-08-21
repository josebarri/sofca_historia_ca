package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.mapper.EpsMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;
@Repository
public class EpsImplements implements EpsDaoInterface {
public JdbcTemplate jdbcTemplate;
public EpsImplements (DataSource dataSource){
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}
    @Override
    public List<EpsDto> selectAll(){
   String SQL = "SELECT id_eps,nombre, direccion, fecha, telefono FROM EPS";

        return jdbcTemplate.query(SQL, new EpsMapper());
    }

    @Override
    public void InsertEps(EpsDto epsDto){
        String INSERT = "INSERT INTO eps(nombre, direccion, fecha, telefono, id_eps) VALUES ( ?, ?, ?, ?,?)";
        jdbcTemplate.update(INSERT,
                epsDto.getNombre(),
                epsDto.getDireccion(),
                epsDto.getFecha(),
                epsDto.getTelefono(),
                epsDto.getId_eps());
        return;
    }

    @Override
    public void EditEps(EpsDto epsDto){
       String UPDATE=("UPDATE eps  SET nombre=?, direccion=?, fecha=?, telefono=? WHERE id_eps=?");

       jdbcTemplate.update(UPDATE,
               epsDto.getNombre(),
               epsDto.getDireccion(),
               epsDto.getFecha(),
               epsDto.getTelefono(),
               epsDto.getId_eps());
       return;
    }

    @Override
    public void DeleteEps(EpsDto epsDto) {
      String DELETE = "DELETE FROM eps WHERE id_eps=?";
      jdbcTemplate.update(DELETE, epsDto.getId_eps());
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
