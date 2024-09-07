package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.TipoIdentificacionDto;
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
public class TipoIdentificacionBusiness implements CrudBusiness<TipoIdentificacionDto> {
    private CrudManager<TipoIdentificacionDto> crudManager;
public TipoIdentificacionBusiness (CrudManager<TipoIdentificacionDto> crudManager){
    this.crudManager = crudManager;
}
    @Override
    @Transactional(readOnly = true)
    public List<TipoIdentificacionDto> selectAll() throws BusinessException {
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
    public TipoIdentificacionDto insert(TipoIdentificacionDto tipoIdentificacionDto) throws BusinessException {
        try{

            this.crudManager.insert(tipoIdentificacionDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return tipoIdentificacionDto;
    }

    @Override
    public void update(TipoIdentificacionDto tipoIdentificacionDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public TipoIdentificacionDto getId(UUID id) throws BusinessException {
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
