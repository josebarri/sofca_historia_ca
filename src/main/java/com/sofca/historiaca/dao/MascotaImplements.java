package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.MascotaMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class MascotaImplements implements CrudDao<MascotaDto> {
public JdbcTemplate jdbcTemplate;
public MascotaImplements(DataSource dataSource){
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}
    @Override
    public List<MascotaDto> selectAll()   throws DaoException{
        try{
            String SQL = "SELECT  m.id_mascota, m.fnac_mascota, m.nombre_mascota,m.raza,m.especie,\n" +
                    "    d.id_dueño,\n" +
                    "    d.nombre_dueño,\n" +
                    "    d.apellido_dueño,\n" +
                    "    d.telefono,\n" +
                    "    d.num_identificacion FROM mascota m INNER JOIN dueño d ON m.id_dueño = d.id_dueño";
            return jdbcTemplate.query(SQL, new MascotaMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public MascotaDto insert(MascotaDto mascotaDto) throws DaoException {
        return null;
    }

    @Override
    public MascotaDto getId(UUID id) throws DaoException {
        return null;
    }

    @Override
    public void update(MascotaDto mascotaDto) throws DaoException {

    }

    @Override
    public void deleteId(UUID id) throws DaoException {

    }

    @Override
    public void InsertEps(MascotaDto mascotaDto)  throws DaoException {
        String INSERT = "INSERT INTO eps(nombre, direccion, fecha, telefono, id_eps) VALUES ( ?, ?, ?, ?,?)";
        try{
            jdbcTemplate.update(INSERT,
                    mascotaDto.getNombre(),
                    mascotaDto.getDireccion(),
                    mascotaDto.getFecha(),
                    mascotaDto.getTelefono(),
                    mascotaDto.getId_eps());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return;
    }

    @Override
    public void EditEps(MascotaDto mascotaDto) throws DaoException{
       String UPDATE=("UPDATE eps  SET nombre=?, direccion=?, fecha=?, telefono=? WHERE id_eps=?");
        try {
            jdbcTemplate.update(UPDATE,
                    mascotaDto.getNombre(),
                    mascotaDto.getDireccion(),
                    mascotaDto.getFecha(),
                    mascotaDto.getTelefono(),
                    mascotaDto.getId_eps());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
       return;
    }

    @Override
    public void DeleteEps(MascotaDto mascotaDto) throws DaoException{
      String DELETE = "DELETE FROM eps WHERE id_eps=?";
        try {
          jdbcTemplate.update(DELETE, mascotaDto.getId_eps());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public MascotaDto EpsID(MascotaDto mascotaDto){
         try {
             String QUERY = "SELECT id_eps,nombre, direccion, fecha, telefono FROM eps WHERE id_eps=?";
             return jdbcTemplate.queryForObject(QUERY, new MascotaMapper(), mascotaDto.getId_eps());

         }catch (EmptyResultDataAccessException ex){
             return null;
         }
     }
}
