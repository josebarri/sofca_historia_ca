package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
import com.sofca.historiaca.exception.BusinessException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudBusiness;
import com.sofca.historiaca.util.crud.CrudManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class PacienteBusiness implements CrudBusiness<PacienteDto> {
    private CrudManager<PacienteDto> crudManager;
    public PacienteBusiness(CrudManager<PacienteDto> crudManager){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<PacienteDto> selectAll() throws BusinessException {
        try{
            return this.crudManager.selectAll();
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public PacienteDto insert(PacienteDto pacienteDto) throws BusinessException {
        try{

            this.crudManager.insert(pacienteDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return pacienteDto;
    }

    @Override
    public void update(PacienteDto pacienteDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDto getId(UUID id) throws BusinessException {
        try {
            return this.crudManager.getId(id);
        } catch (ManagerException ex) {
            throw new BusinessException(ex);
        } catch (Exception ex) {
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void deleteId(UUID id) throws BusinessException {
        try{
            this.crudManager.deleteId(id);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }
}
