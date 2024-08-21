package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;

import java.util.List;

public interface HistoCliDaoInterface {
    public List<HistoriaClinicaDto> selectAll();
    public void InsertEps(HistoriaClinicaDto historiaClinicaDto);

    public void EditEps(HistoriaClinicaDto historiaClinicaDto);
    public void DeleteEps(HistoriaClinicaDto historiaClinicaDto);
    public EpsDto EpsID(HistoriaClinicaDto historiaClinicaDto);
}
