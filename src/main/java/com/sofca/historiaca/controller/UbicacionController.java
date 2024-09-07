package com.sofca.historiaca.controller;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.UbicacionDto;
import com.sofca.historiaca.util.ResponseMessage;
import com.sofca.historiaca.util.crud.CrudBusiness;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/ubicacion")
@CrossOrigin
public class UbicacionController {
    @Autowired
    private CrudBusiness<UbicacionDto> crudBusiness;


    @Operation(summary = "List ubicacion", description = "Proporciona una lista de Ubicaciones disponibles.")
    @GetMapping("/UbicacionAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<UbicacionDto> list = null;
        ResponseMessage message = null;
        try {
            list = this.crudBusiness.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }



    @PostMapping("/saveUbicacion")
    public ResponseEntity<ResponseMessage<UbicacionDto>> insert(@RequestBody UbicacionDto request){
        log.debug("REST request to insert Eps: {}", request);
        ResponseMessage message = null;
        try {
            crudBusiness.insert(request);
            message = new ResponseMessage<>(200, "insertar, process successful", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }


    @Operation(summary = "List EPS", description = "Proporciona una EPS disponibles.")
    @GetMapping("/ubicacion/{id}")
    public ResponseEntity<ResponseMessage<UbicacionDto>> findById(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            UbicacionDto ubicacionDtoO = crudBusiness.getId(id);

            message = new ResponseMessage<>(200, "findById, process successful ", ubicacionDtoO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }



    @Operation(summary = "List EPS", description = "Proporciona una EPS disponibles.")
    @DeleteMapping("/ubicacion/delete/{id}")
    public ResponseEntity<ResponseMessage<UbicacionDto>> dalete(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            this.crudBusiness.deleteId(id);

            message = new ResponseMessage<>(200, "delete, process successful ", id);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }


}
