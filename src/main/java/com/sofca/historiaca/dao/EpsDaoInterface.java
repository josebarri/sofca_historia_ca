package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;


import java.util.List;
import java.util.Map;

public interface EpsDaoInterface {
    public List<Map<String, Object>> selectAll();
    public void InsertEps(EpsDto epsDto);
    public void EditEps(EpsDto epsDto);
    public void DeleteEps(EpsDto epsDto);
    public EpsDto EpsID(EpsDto epsDto);
}
