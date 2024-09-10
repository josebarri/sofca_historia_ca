package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.mapper.MascotaMapper;
import com.sofca.historiaca.util.crud.CrudDao;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
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
                    "    d.id_dueno,\n" +
                    "    d.nombre_dueno,\n" +
                    "    d.apellido_dueno,\n" +
                    "    d.telefono,\n" +
                    "    d.num_identificacion,d.id_ubicacion, d.identificacion FROM mascota m INNER JOIN dueno d ON m.id_dueno = d.id_dueno";
            return jdbcTemplate.query(SQL, new MascotaMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public MascotaDto insert(MascotaDto mascotaDto) throws DaoException {
        String INSERT = "INSERT INTO mascota ( fnac_mascota, nombre_mascota, raza, especie, id_dueno)VALUES ( ?, ?, ?, ?,?)";
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement preparedStatement = con.prepareStatement(INSERT, new String[]{"id_mascota"});
                preparedStatement.setObject(1, mascotaDto.getFnac_mascota());
                preparedStatement.setString(2, mascotaDto.getNombre_mascota());
                preparedStatement.setString(3, mascotaDto.getRaza());
                preparedStatement.setString(4, mascotaDto.getEspecie());
                preparedStatement.setObject(5, mascotaDto.getDuenoDto().getId_Dueño());
                return preparedStatement;
            }, keyHolder);
            Map<String, Object> keys = keyHolder.getKeyList().get(0);
            mascotaDto.setId_mascota((UUID) keys.get("id_mascota"));
        }catch (BadSqlGrammarException be) {
            System.out.println("entro aqui");
            be.printStackTrace();
        }catch(DataAccessException ex){
            ex.printStackTrace();
            throw new DaoException(ex);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new DaoException(ex);
        }

        return mascotaDto;
    }

    @Override
    public MascotaDto getId(UUID id) throws DaoException {
    String selectID ="SELECT  m.id_mascota, m.fnac_mascota, m.nombre_mascota,m.raza,m.especie, d.id_dueno, d.nombre_dueno,d.apellido_dueno, d.telefono,d.num_identificacion,d.id_ubicacion, d.identificacion FROM mascota m INNER JOIN dueno d ON m.id_dueno = d.id_dueno where m.id_mascota= ?";
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
        String UPDATE=("UPDATE mascota  SET nombre_mascota=?, fnac_mascota=?, raza=?, especie=?,id_dueno=?  WHERE id_mascota=?");
        try {
            jdbcTemplate.update(UPDATE,
                    mascotaDto.getNombre_mascota(),
                    mascotaDto.getFnac_mascota(),
                    mascotaDto.getRaza(),
                    mascotaDto.getEspecie(),
                    mascotaDto.getDuenoDto().getId_Dueño(),
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








