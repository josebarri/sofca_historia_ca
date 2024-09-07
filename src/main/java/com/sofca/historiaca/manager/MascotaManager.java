package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudDao;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MascotaManager implements CrudManager<MascotaDto> {
    public CrudDao<MascotaDto> crudDao;
    public MascotaManager(CrudDao<MascotaDto> crudDao){
        this.crudDao = crudDao;
    }
    @Override
    public List<MascotaDto> selectAll() throws ManagerException {
        try {
            return this.crudDao.selectAll();

        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }
    }

    @Override
    public MascotaDto insert(MascotaDto mascotaDto) throws ManagerException {
        try {
            MascotaDto mascotaDto1 = this.crudDao.getId(mascotaDto.getId_mascota());
            if (mascotaDto1 == null) {
                this.crudDao.insert(mascotaDto);
            } else {
                this.crudDao.update(mascotaDto);
            }
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

        return mascotaDto;
    }

    @Override
    public void update(MascotaDto mascotaDto) throws ManagerException {

    }

    @Override
    public MascotaDto getId(UUID id) throws ManagerException {
        MascotaDto mascotaDto1 = null;
        try{
            mascotaDto1 = this.crudDao.getId(id);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return mascotaDto1;
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
