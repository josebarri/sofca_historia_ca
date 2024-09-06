package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.ManagerException;

import java.util.List;
import java.util.Map;

public interface EpsManagerInterface {
    public List<Map<String, Object>> selectAll() throws ManagerException;
    public void InsertEps(MascotaDto mascotaDto) throws ManagerException;
    public void EditEps(MascotaDto mascotaDto) throws ManagerException;
    public void DeleteEps(MascotaDto mascotaDto) throws ManagerException;
    public MascotaDto EpsID(MascotaDto mascotaDto) throws ManagerException;
}
