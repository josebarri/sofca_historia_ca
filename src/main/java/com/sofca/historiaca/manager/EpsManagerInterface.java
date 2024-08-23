package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.exception.ManagerException;

import java.util.List;
import java.util.Map;

public interface EpsManagerInterface {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public void InsertEps(EpsDto epsDto) throws ManagerException;
    public void EditEps(EpsDto epsDto) throws ManagerException;
    public void DeleteEps(EpsDto epsDto) throws ManagerException;
    public EpsDto EpsID(EpsDto epsDto) throws ManagerException;
}
