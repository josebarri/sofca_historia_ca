package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudDao;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PacienteManager implements CrudManager<PacienteDto> {
    public CrudDao<PacienteDto> crudDao;
    public PacienteManager(CrudDao<PacienteDto> crudDao){
        this.crudDao = crudDao;
    }
    @Override
    public List<PacienteDto> selectAll() throws ManagerException {
        try {
            return this.crudDao.selectAll();

        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }
    }

    @Override
    public PacienteDto insert(PacienteDto pacienteDto) throws ManagerException {
        try {
            PacienteDto pacienteDto1 = this.crudDao.getId(pacienteDto.getIdPaciente());
            if (pacienteDto1 == null) {
                this.crudDao.insert(pacienteDto);
            } else {
                this.crudDao.update(pacienteDto);
            }
        } catch (DaoException ex) {
            throw new ManagerException(ex);
        } catch (Exception ex) {
            throw new ManagerException(ex);
        }

        return pacienteDto;
    }

    @Override
    public void update(PacienteDto pacienteDto) throws ManagerException {

    }

    @Override
    public PacienteDto getId(UUID id) throws ManagerException {
        PacienteDto pacienteDto1 = null;
        try{
            pacienteDto1 = this.crudDao.getId(id);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return pacienteDto1;
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
