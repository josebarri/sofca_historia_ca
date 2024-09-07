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
                    "    d.num_identificacion,d.id_ubicacion, d.identificacion FROM mascota m INNER JOIN dueño d ON m.id_dueño = d.id_dueño";
            return jdbcTemplate.query(SQL, new MascotaMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public MascotaDto insert(MascotaDto mascotaDto) throws DaoException {
        String INSERT = "INSERT INTO mascota (id_mascota, fnac_mascota, nombre_mascota, raza, especie, id_dueño)\n" +
                "VALUES ( ?, ?, ?, ?,?, ?)";
        try{
            jdbcTemplate.update(INSERT,
                    mascotaDto.getId_mascota(),
                    mascotaDto.getFnac_mascota(),
                    mascotaDto.getNombre_mascota(),
                    mascotaDto.getRaza(),
                    mascotaDto.getEspecie(),
                    mascotaDto.getDuenoDto().getId_Dueño());

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

        return mascotaDto;
    }

    @Override
    public MascotaDto getId(UUID id) throws DaoException {
    String selectID ="SELECT  m.id_mascota, m.fnac_mascota, m.nombre_mascota,m.raza,m.especie,\\n\" +\n" +
            "                    \"    d.id_dueño,\\n\" +\n" +
            "                    \"    d.nombre_dueño,\\n\" +\n" +
            "                    \"    d.apellido_dueño,\\n\" +\n" +
            "                    \"    d.telefono,\\n\" +\n" +
            "                    \"    d.num_identificacion,d.id_ubicacion, d.identificacion FROM mascota m INNER JOIN dueño d ON m.id_dueño = d.id_dueño where m.id_mascota= ?";
        try {
            return this.jdbcTemplate.queryForObject(selectID, new MascotaMapper(), id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }catch (Exception exception){
            throw new DaoException(exception);
        }

    }


    @Override
    public void update(MascotaDto mascotaDto) throws DaoException {
        String UPDATE=("UPDATE eps  SET nombre_mascota=?, fnac_mascota=?, raza=?, especie=?,id_dueño=?  WHERE id_mascota=?");
        try {
            jdbcTemplate.update(UPDATE,
                    mascotaDto.getNombre_mascota(),
                    mascotaDto.getEspecie(),
                    mascotaDto.getDuenoDto().getId_Dueño(),
                    mascotaDto.getFnac_mascota(),
                    mascotaDto.getRaza(),
                    mascotaDto.getId_mascota()
            );
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


    @Override
    public void deleteId(UUID id) throws DaoException {
        String DELETE = "DELETE FROM mascota WHERE id_mascota=?";
        try {
            jdbcTemplate.update(DELETE, id );

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
}








