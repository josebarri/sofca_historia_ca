package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudDao;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DuenoManager implements CrudManager<DuenoDto> {
    public CrudDao<DuenoDto> crudDao;
    public DuenoManager(CrudDao<DuenoDto> crudDao){
        this.crudDao = crudDao;
    }
    @Override
    public List<DuenoDto> selectAll() throws ManagerException {
        try {
            return this.crudDao.selectAll();

        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }
    }

    @Override
    public DuenoDto insert(DuenoDto duenoDto) throws ManagerException {
        try {
            DuenoDto duenoDto1 = this.crudDao.getId(duenoDto.getId_Dueño());
            if (duenoDto1 == null) {
                this.crudDao.insert(duenoDto);
            } else {
                this.crudDao.update(duenoDto);
            }
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

        return duenoDto;
    }

    @Override
    public void update(DuenoDto duenoDto) throws ManagerException {

    }

    @Override
    public DuenoDto getId(UUID id) throws ManagerException {
        DuenoDto duenoDto1 = null;
        try{
            duenoDto1 = this.crudDao.getId(id);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return duenoDto1;
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
