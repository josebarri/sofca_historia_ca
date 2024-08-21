package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;


import java.util.List;

public interface EpsDaoInterface {
    public List<EpsDto> selectAll();
    public void InsertEps(EpsDto epsDto);

    public void EditEps(EpsDto epsDto);
    public void DeleteEps(EpsDto epsDto);
    public EpsDto EpsID(EpsDto epsDto);
}
