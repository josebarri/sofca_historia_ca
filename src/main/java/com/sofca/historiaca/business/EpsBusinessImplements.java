package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.manager.EpsManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class EpsBusinessImplements implements EpsBusinessInterface {
private EpsManagerInterface epsManagerInterface;
public EpsBusinessImplements(EpsManagerInterface epsManagerInterface){
    this.epsManagerInterface=epsManagerInterface;
}

    @Override
    public List<Map<String, Object>> selectAll() throws Exception {
        return this.epsManagerInterface.selectAll();
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
        this.epsManagerInterface.DeleteEps(epsDto);
    }

    @Override
    public EpsDto EpsID(EpsDto epsDto)throws Exception {
        return this.epsManagerInterface.EpsID(epsDto);
    }
}
