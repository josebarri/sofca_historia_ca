package com.sofca.historiaca.manager;

import com.sofca.historiaca.dao.EpsDaoInterface;
import com.sofca.historiaca.dto.EpsDto;
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
    public List<Map<String, Object>> selectAll() {
    return this.epsI.selectAll();
    }

    @Override
    public void InsertEps(EpsDto epsDto) {
    EpsDto epsDto1 = this.epsI.EpsID(epsDto);
    if (epsDto1==null){
        this.epsI.InsertEps(epsDto);
    }else {
        this.epsI.EditEps(epsDto);
    }
    }

    @Override
    public void EditEps(EpsDto epsDto) {

    }

    @Override
    public void DeleteEps(EpsDto epsDto) {

    }

    @Override
    public EpsDto EpsID(EpsDto epsDto) {
        EpsDto epsDto1 = this.epsI.EpsID(epsDto);
        return epsDto1;
    }
}
