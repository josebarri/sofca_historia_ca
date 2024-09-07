package com.sofca.historiaca.business;

import com.sofca.historiaca.dao.UbicacionImplements;
import com.sofca.historiaca.dto.UbicacionDto;
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
public class UbicacionBusiness implements CrudBusiness<UbicacionDto> {
    private CrudManager<UbicacionDto> crudManager;

    public UbicacionBusiness (CrudManager<UbicacionDto> crudManager ){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<UbicacionDto> selectAll() throws BusinessException {
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
    public UbicacionDto insert(UbicacionDto ubicacionDto) throws BusinessException {
        try{

            this.crudManager.insert(ubicacionDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return ubicacionDto;
    }

    @Override
    public void update(UbicacionDto ubicacionDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public UbicacionDto getId(UUID id) throws BusinessException {
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
