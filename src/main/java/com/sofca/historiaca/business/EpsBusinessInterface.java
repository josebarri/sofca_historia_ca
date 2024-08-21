package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;

import java.util.List;

public interface EpsBusinessInterface {
    public List<EpsDto> selectAll() throws Exception;
    public void InsertEps(EpsDto epsDto)throws Exception;

    public void EditEps(EpsDto epsDto)throws Exception;
    public void DeleteEps(EpsDto epsDto)throws Exception;
    public EpsDto EpsID(EpsDto epsDto)throws Exception;
}
