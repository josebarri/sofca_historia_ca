package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;

import java.util.List;
import java.util.Map;

public interface HistoriaManagerInterface {
    public List<Map<String, Object>> selectAll();
    public void InsertHisto(HistoriaClinicaDto historiaClinicaDto);

    public void EditHisto(HistoriaClinicaDto historiaClinicaDto);
    public void DeleteHisto(HistoriaClinicaDto historiaClinicaDto);
    public HistoriaClinicaDto histoclinicabyid(HistoriaClinicaDto historiaClinicaDto);
}
