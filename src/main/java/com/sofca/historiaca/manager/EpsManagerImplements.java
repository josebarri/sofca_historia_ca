package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.DaoException;
import com.sofca.historiaca.exception.ManagerException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EpsManagerImplements implements EpsManagerInterface {
public EpsDaoInterface epsI;
public EpsManagerImplements(EpsDaoInterface epsI){
    this.epsI = epsI;
}
    @Override
    public List<Map<String, Object>> selectAll() throws ManagerException {
        try {
            return this.epsI.selectAll();

        }catch (DaoException ex){
            throw new ManagerException(ex);
        }catch (Exception ex){
            throw new ManagerException(ex);
        }

    }

    @Override
    public void InsertEps(MascotaDto mascotaDto) throws ManagerException{
        try{
            MascotaDto mascotaDto1 = this.epsI.EpsID(mascotaDto);
            if (mascotaDto1 ==null){
                this.epsI.InsertEps(mascotaDto);
            }else {
                this.epsI.EditEps(mascotaDto);
            }
        }catch (DaoException ex){
            throw new ManagerException(ex);
        }catch (Exception ex){
            throw new ManagerException(ex);
        }
    }

    @Override
    public void EditEps(MascotaDto mascotaDto) throws ManagerException{

    }

    @Override
    public void DeleteEps(MascotaDto mascotaDto) throws ManagerException{
        try{
            this.epsI.DeleteEps(mascotaDto);
        }catch (DaoException ex){
            throw new ManagerException(ex);
        }catch (Exception ex){
            throw new ManagerException(ex);
        }
    }

    @Override
    public MascotaDto EpsID(MascotaDto mascotaDto) throws ManagerException {
        MascotaDto mascotaDto1 = null;
        try{
             mascotaDto1 = this.epsI.EpsID(mascotaDto);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return mascotaDto1;
    }
}
