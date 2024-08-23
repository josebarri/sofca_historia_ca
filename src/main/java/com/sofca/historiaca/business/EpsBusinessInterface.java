package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface EpsBusinessInterface {
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void InsertEps(EpsDto epsDto)throws BusinessException;

    public void EditEps(EpsDto epsDto)throws BusinessException;
    public void DeleteEps(EpsDto epsDto)throws BusinessException;
    public EpsDto EpsID(EpsDto epsDto)throws BusinessException;
}
