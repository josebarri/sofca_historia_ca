package com.sofca.historiaca.manager;

import com.sofca.historiaca.dao.EpsDaoInterface;
import com.sofca.historiaca.dto.EpsDto;
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
    public void InsertEps(EpsDto epsDto) throws ManagerException{
        try{
            EpsDto epsDto1 = this.epsI.EpsID(epsDto);
            if (epsDto1==null){
                this.epsI.InsertEps(epsDto);
            }else {
                this.epsI.EditEps(epsDto);
            }
        }catch (DaoException ex){
            throw new ManagerException(ex);
        }catch (Exception ex){
            throw new ManagerException(ex);
        }
    }

    @Override
    public void EditEps(EpsDto epsDto) throws ManagerException{

    }

    @Override
    public void DeleteEps(EpsDto epsDto) throws ManagerException{
        try{
            this.epsI.DeleteEps(epsDto);
        }catch (DaoException ex){
            throw new ManagerException(ex);
        }catch (Exception ex){
            throw new ManagerException(ex);
        }
    }

    @Override
    public EpsDto EpsID(EpsDto epsDto) throws ManagerException {
        EpsDto epsDto1 = null;
        try{
             epsDto1 = this.epsI.EpsID(epsDto);

        }catch (Exception ex){
            throw new ManagerException(ex);
        }
        return epsDto1;
    }
}
