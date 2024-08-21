package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.manager.EpsManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EpsBusinessImplements implements EpsBusinessInterface {
private EpsManagerInterface epsManagerInterface;
public EpsBusinessImplements(EpsManagerInterface epsManagerInterface){
    this.epsManagerInterface=epsManagerInterface;
}

    @Override
    public List<EpsDto> selectAll()throws Exception {
        return null;
    }

    @Override
    public void InsertEps(EpsDto epsDto)throws Exception {
    this.epsManagerInterface.InsertEps(epsDto);
    }

    @Override
    public void EditEps(EpsDto epsDto)throws Exception {

    }

    @Override
    public void DeleteEps(EpsDto epsDto)throws Exception {

    }

    @Override
    public EpsDto EpsID(EpsDto epsDto)throws Exception {
        return this.epsManagerInterface.EpsID(epsDto);
    }
}
