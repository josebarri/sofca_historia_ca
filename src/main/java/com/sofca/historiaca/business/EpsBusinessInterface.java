package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;

import java.util.List;
import java.util.Map;

public interface EpsBusinessInterface {
    public List<Map<String, Object>> selectAll() throws Exception;
    public void InsertEps(EpsDto epsDto)throws Exception;

    public void EditEps(EpsDto epsDto)throws Exception;
    public void DeleteEps(EpsDto epsDto)throws Exception;
    public EpsDto EpsID(EpsDto epsDto)throws Exception;
}
