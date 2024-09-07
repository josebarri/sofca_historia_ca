package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.UbicacionDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudDao;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
public class UbicacionManager implements CrudManager<UbicacionDto> {
    public CrudDao<UbicacionDto> crudDao;

    public UbicacionManager(CrudDao<UbicacionDto> crudDao) {
        this.crudDao = crudDao;

    }

    @Override
    public List<UbicacionDto> selectAll() throws ManagerException {
        try {
            return this.crudDao.selectAll();

        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }
    }

    @Override
    public UbicacionDto insert(UbicacionDto ubicacionDto) throws ManagerException {
        try {
            UbicacionDto ubicacionDto1 = this.crudDao.insert(ubicacionDto);
            if (ubicacionDto1 == null) {
                this.crudDao.insert(ubicacionDto);
            } else {
                this.crudDao.update(ubicacionDto);
            }
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

        return ubicacionDto;
    }


    @Override
    public void update(UbicacionDto ubicacionDto) throws ManagerException {

    }

    @Override
    public UbicacionDto getId(UUID id) throws ManagerException {
        UbicacionDto ubicacion1 = null;
        try{
            ubicacion1 = this.crudDao.getId(id);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return ubicacion1;

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
