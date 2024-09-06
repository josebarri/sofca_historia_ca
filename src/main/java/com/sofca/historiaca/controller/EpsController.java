package com.sofca.historiaca.controller;

import com.sofca.historiaca.business.EpsBusinessInterface;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.util.ResponseMessage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/eps")
@CrossOrigin
public class EpsController {
@Autowired
    private EpsBusinessInterface epsBusinessInterface;
@PostMapping("/saveEps")
public ResponseEntity<ResponseMessage<MascotaDto>> insert(@RequestBody MascotaDto request){
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
    public ResponseEntity<ResponseMessage<MascotaDto>> findById(@RequestBody MascotaDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            MascotaDto mascotaDtoO = epsBusinessInterface.EpsID(request);

            message = new ResponseMessage<>(200, "findById, process successful ", mascotaDtoO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }
    @Operation(summary = "List EPS", description = "Proporciona una lista de EPS disponibles.")
    @GetMapping("/epsAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<Map<String, Object>> list = null;
        ResponseMessage message = null;
        try {
            list = this.epsBusinessInterface.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }
    @Operation(summary = "List EPS", description = "Proporciona una EPS disponibles.")
    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<MascotaDto>> dalete(@RequestBody MascotaDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            this.epsBusinessInterface.DeleteEps(request);

            message = new ResponseMessage<>(200, "delete, process successful ", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }

}
