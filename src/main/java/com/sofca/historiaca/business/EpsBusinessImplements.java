package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.exception.BusinessException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.manager.EpsManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class EpsBusinessImplements implements EpsBusinessInterface {
private EpsManagerInterface epsManagerInterface;
public EpsBusinessImplements(EpsManagerInterface epsManagerInterface){
    this.epsManagerInterface=epsManagerInterface;
}

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException {
        try{
            return this.epsManagerInterface.selectAll();
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void InsertEps(EpsDto epsDto)throws BusinessException {
        try{

            this.epsManagerInterface.InsertEps(epsDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }

    }

    @Override
    public void EditEps(EpsDto epsDto)throws BusinessException {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void DeleteEps(EpsDto epsDto)throws BusinessException {
        try{
            this.epsManagerInterface.DeleteEps(epsDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public EpsDto EpsID(EpsDto epsDto)throws BusinessException {
        try{
            return this.epsManagerInterface.EpsID(epsDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }
}
