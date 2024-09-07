package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.DuenoDto;
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
public class DuenoBusiness implements CrudBusiness<DuenoDto> {
    private CrudManager<DuenoDto> crudManager;
    public DuenoBusiness(CrudManager<DuenoDto> crudManager){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<DuenoDto> selectAll() throws BusinessException {
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
    public DuenoDto insert(DuenoDto duenoDto) throws BusinessException {
        try{

            this.crudManager.insert(duenoDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return duenoDto;
    }

    @Override
    public void update(DuenoDto duenoDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public DuenoDto getId(UUID id) throws BusinessException {
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
