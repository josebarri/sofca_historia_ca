package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface EpsBusinessInterface {
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void InsertEps(MascotaDto mascotaDto)throws BusinessException;

    public void EditEps(MascotaDto mascotaDto)throws BusinessException;
    public void DeleteEps(MascotaDto mascotaDto)throws BusinessException;
    public MascotaDto EpsID(MascotaDto mascotaDto)throws BusinessException;
}
