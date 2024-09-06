package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.MascotaDto;
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
    public void InsertEps(MascotaDto mascotaDto)throws BusinessException {
        try{

            this.epsManagerInterface.InsertEps(mascotaDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }

    }

    @Override
    public void EditEps(MascotaDto mascotaDto)throws BusinessException {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void DeleteEps(MascotaDto mascotaDto)throws BusinessException {
        try{
            this.epsManagerInterface.DeleteEps(mascotaDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MascotaDto EpsID(MascotaDto mascotaDto)throws BusinessException {
        try{
            return this.epsManagerInterface.EpsID(mascotaDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }
}
