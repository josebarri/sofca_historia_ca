package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.MascotaDto;
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
public class MascotaBusiness implements CrudBusiness<MascotaDto> {
    private CrudManager<MascotaDto> crudManager;
    public MascotaBusiness(CrudManager<MascotaDto> crudManager){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<MascotaDto> selectAll() throws BusinessException {
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
    public MascotaDto insert(MascotaDto mascotaDto) throws BusinessException {
        try{

            this.crudManager.insert(mascotaDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return mascotaDto;
    }

    @Override
    public void update(MascotaDto mascotaDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public MascotaDto getId(UUID id) throws BusinessException {
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
