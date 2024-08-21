package com.sofca.historiaca.controller;

import com.sofca.historiaca.business.EpsBusinessInterface;
import com.sofca.historiaca.dto.EpsDto;
import com.sofca.historiaca.util.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/eps")
public class EpsController {
@Autowired
    private EpsBusinessInterface epsBusinessInterface;

@PostMapping("/saveEps")
public ResponseEntity<ResponseMessage<EpsDto>> insert(@RequestBody EpsDto request){
    log.debug("REST request to insert Eps: {}", request);
    ResponseMessage message = null;
    try {
        epsBusinessInterface.InsertEps(request);
        message = new ResponseMessage<>(200, "insertar, process successful", request);
    }catch (Exception ex){
        message = new ResponseMessage<>(406, ex.getMessage(), request);
    }
    return ResponseEntity.ok(message);
}
    @Operation(summary = "List EPS", description = "Proporciona una EPS disponibles.")
    @PostMapping("/findById")
    public ResponseEntity<ResponseMessage<EpsDto>> findById(@RequestBody EpsDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            EpsDto epsDtoO= epsBusinessInterface.EpsID(request);

            message = new ResponseMessage<>(200, "findById, process successful ", epsDtoO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }
}
