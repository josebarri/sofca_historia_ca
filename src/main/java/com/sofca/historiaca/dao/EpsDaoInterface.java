package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.exception.DaoException;


import java.util.List;
import java.util.Map;

public interface EpsDaoInterface {
    public List<Map<String, Object>> selectAll() throws DaoException;
    public void InsertEps(EpsDto epsDto) throws DaoException;
    public void EditEps(EpsDto epsDto) throws DaoException;
    public void DeleteEps(EpsDto epsDto) throws DaoException;
    public EpsDto EpsID(EpsDto epsDto);
}
