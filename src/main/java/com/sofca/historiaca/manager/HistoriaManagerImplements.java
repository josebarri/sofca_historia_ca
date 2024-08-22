package com.sofca.historiaca.manager;

import com.sofca.historiaca.dao.HistoCliDaoInterface;
import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class HistoriaManagerImplements implements HistoriaManagerInterface{
public HistoCliDaoInterface histoCliDaoInterface;

public HistoriaManagerImplements(HistoCliDaoInterface histoCliDaoInterface){
    this.histoCliDaoInterface = histoCliDaoInterface;
}

    @Override
    public List<Map<String, Object>> selectAll() {
        return null;
    }

    @Override
    public void InsertHisto(HistoriaClinicaDto historiaClinicaDto) {
        HistoriaClinicaDto historiaClinicaDto1 = this.histoCliDaoInterface.histoclinicabyid(historiaClinicaDto);
        if (historiaClinicaDto1==null){
            this.histoCliDaoInterface.InsertHisto(historiaClinicaDto);
        }else {
            this.histoCliDaoInterface.EditHisto(historiaClinicaDto);
        }
    }

    @Override
    public void EditHisto(HistoriaClinicaDto historiaClinicaDto) {

    }

    @Override
    public void DeleteHisto(HistoriaClinicaDto historiaClinicaDto) {

    }

    @Override
    public HistoriaClinicaDto histoclinicabyid(HistoriaClinicaDto historiaClinicaDto) {
        HistoriaClinicaDto historiaClinicaDto1 = this.histoCliDaoInterface.histoclinicabyid(historiaClinicaDto);
        return historiaClinicaDto1;
    }
}
