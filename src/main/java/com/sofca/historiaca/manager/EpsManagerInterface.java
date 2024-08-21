package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.EpsDto;

import java.util.List;

public interface EpsManagerInterface {
    public List<EpsDto> selectAll();
    public void InsertEps(EpsDto epsDto);
    public void EditEps(EpsDto epsDto);
    public void DeleteEps(EpsDto epsDto);
    public EpsDto EpsID(EpsDto epsDto);
}
