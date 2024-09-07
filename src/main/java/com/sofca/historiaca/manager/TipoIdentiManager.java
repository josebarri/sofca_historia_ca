package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.dto.UbicacionDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudDao;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TipoIdentiManager implements CrudManager<TipoIdentificacionDto> {
    public CrudDao<TipoIdentificacionDto> crudDao;
    public TipoIdentiManager (CrudDao<TipoIdentificacionDto> crudDao){
        this.crudDao = crudDao;
    }
    @Override
    public List<TipoIdentificacionDto> selectAll() throws ManagerException {
        try {
            return this.crudDao.selectAll();

        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }
    }

    @Override
    public TipoIdentificacionDto insert(TipoIdentificacionDto tipoIdentificacionDto) throws ManagerException {
        try {
            TipoIdentificacionDto tipoIdentificacionDto1 = this.crudDao.getId(tipoIdentificacionDto.getIdIdentificacion());
            if (tipoIdentificacionDto1 == null) {
                this.crudDao.insert(tipoIdentificacionDto);
            } else {
                this.crudDao.update(tipoIdentificacionDto);
            }
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

        return tipoIdentificacionDto;
    }
    @Override
    public void update(TipoIdentificacionDto tipoIdentificacionDto) throws ManagerException {

    }

    @Override
    public TipoIdentificacionDto getId(UUID id) throws ManagerException {
        TipoIdentificacionDto tipoIdentificacionDto1 = null;
        try{
            tipoIdentificacionDto1 = this.crudDao.getId(id);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return tipoIdentificacionDto1;
    }

    @Override
    public void deleteId(UUID id) throws ManagerException {
        try {
            this.crudDao.deleteId(id);
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

    }
}
