package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;

import java.util.List;

public interface EpsI {
    public List<EpsDto> selectAll() throws Exception;
    public void InsertEps(EpsDto epsDto) throws Exception;

    public void EditEps(EpsDto epsDto) throws Exception;
    public void DeleteEps(Integer identidad) throws Exception;
    public EpsDto EpsID(Integer identidad) throws Exception;
}
