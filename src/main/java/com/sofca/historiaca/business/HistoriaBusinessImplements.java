package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.HistoriaClinicaDto;
import com.sofca.historiaca.manager.HistoriaManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component
@Transactional
public class HistoriaBusinessImplements implements HistoriaBusinessInterface {
    private HistoriaManagerInterface historiaManagerInterface;

    public HistoriaBusinessImplements (HistoriaManagerInterface historiaManagerInterface){
        this.historiaManagerInterface = historiaManagerInterface;
    }
    @Override
    public List<Map<String, Object>> selectAll() {
        return null;
    }

    @Override
    public void InsertHisto(HistoriaClinicaDto historiaClinicaDto) {
    this.historiaManagerInterface.InsertHisto(historiaClinicaDto);
    }

    @Override
    public void EditHisto(HistoriaClinicaDto historiaClinicaDto) {

    }

    @Override
    public void DeleteHisto(HistoriaClinicaDto historiaClinicaDto) {

    }

    @Override
    public HistoriaClinicaDto histoclinicabyid(HistoriaClinicaDto historiaClinicaDto) {
        return this.historiaManagerInterface.histoclinicabyid(historiaClinicaDto);
    }
}
