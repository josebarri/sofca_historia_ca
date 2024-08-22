package com.sofca.historiaca.controller;

import com.sofca.historiaca.business.HistoriaBusinessInterface;
import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.dto.HistoriaClinicaDto;
import com.sofca.historiaca.util.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/historia")
public class HistoriaController {

    private HistoriaBusinessInterface historiaBusinessInterface;
    public HistoriaController(HistoriaBusinessInterface historiaBusinessInterface){
        this.historiaBusinessInterface = historiaBusinessInterface;
    }
    @PostMapping("/saveHIsto")
    public ResponseEntity<ResponseMessage<HistoriaClinicaDto>> insert(@RequestBody HistoriaClinicaDto request){
        log.debug("REST request to insert Eps: {}", request);
        ResponseMessage message = null;
        try {
            historiaBusinessInterface.InsertHisto(request);
            message = new ResponseMessage<>(200, "insertar, process successful", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }
    @Operation(summary = "List EPS", description = "Proporciona una EPS disponibles.")
    @PostMapping("/findById")
    public ResponseEntity<ResponseMessage<HistoriaClinicaDto>> findById(@RequestBody HistoriaClinicaDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            HistoriaClinicaDto historiaClinicaDto=  historiaBusinessInterface.histoclinicabyid(request);

            message = new ResponseMessage<>(200, "findById, process successful ", historiaClinicaDto);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }
}
