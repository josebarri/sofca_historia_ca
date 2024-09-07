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
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;
@Repository
public class dueñoImplements implements CrudDao<DuenoDto> {
    public JdbcTemplate jdbcTemplate;
    public dueñoImplements (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<DuenoDto> selectAll() throws DaoException {
        try{
            String SQL = "SELECT id_dueno,nombre_dueno,  apellido_dueno, telefono,num_identificacion, identificacion, id_ubicacion FROM  Dueno";
            return jdbcTemplate.query(SQL, new DuenoMapper());
        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    @Override
    public DuenoDto insert(DuenoDto duenoDto) throws DaoException {
        String INSERT = "INSERT INTO Dueno (nombre_dueno, apellido_dueno, telefono, identificacion, id_ubicacion, num_identificacion) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(INSERT,
                    duenoDto.getNombreDueño(),
                    duenoDto.getApellidoDueño(),
                    duenoDto.getTelefono(),
                    duenoDto.getTipoIdentificacionDto().getIdIdentificacion(), // UUID
                    duenoDto.getUbicacionDto().getIdUbicacion(), // UUID
                    duenoDto.getNum_identificacion());
        } catch (DataAccessException ex) {
            throw new DaoException(ex);
        } catch (Exception ex) {
            throw new DaoException(ex);
        }
        return duenoDto;
    }

    @Override
    public DuenoDto getId(UUID id) throws DaoException {
        String selectID ="SELECT   id_dueno,nombre_dueno,  apellido_dueno, telefono,num_identificacion, identificacion, id_ubicacion FROM  Dueno where id_dueno=? ";
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
        // C
        String UPDATE = "UPDATE Dueno SET nombre_dueno=?, apellido_dueno=?, telefono=?, identificacion=?, id_ubicacion=?, num_identificacion=? WHERE id_dueno=?";

        try {

            jdbcTemplate.update(UPDATE,
                    duenoDto.getNombreDueño(),
                    duenoDto.getApellidoDueño(),
                    duenoDto.getTelefono(),
                    duenoDto.getTipoIdentificacionDto().getIdIdentificacion(),
                    duenoDto.getUbicacionDto().getIdUbicacion(),
                    duenoDto.getNum_identificacion(),
                    duenoDto.getId_Dueño()
            );
        } catch (DataAccessException ex) {

            throw new DaoException(ex);
        } catch (Exception ex) {

            throw new DaoException(ex);
        }
    }

    @Override
    public void deleteId(UUID id) throws DaoException {

        String DELETE = "DELETE FROM Dueno WHERE id_dueno=?";
        try {
            jdbcTemplate.update(DELETE, id );

        }catch(DataAccessException ex){
            throw new DaoException(ex);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }
}

