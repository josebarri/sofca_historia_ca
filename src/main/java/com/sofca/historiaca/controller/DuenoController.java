package com.sofca.historiaca.controller;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.TipoIdentificacionDto;
import com.sofca.historiaca.util.ResponseMessage;
import com.sofca.historiaca.util.crud.CrudBusiness;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/dueño")
@CrossOrigin
public class DuenoController {
    @Autowired
    private CrudBusiness<DuenoDto> crudBusiness;

    @Operation(summary = "List Dueños", description = "Proporciona una lista de Dueños.")
    @GetMapping("/dueñoAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<DuenoDto> list = null;
        ResponseMessage message = null;
        try {
            list = this.crudBusiness.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }



    @PostMapping("/saveDueño")
    public ResponseEntity<ResponseMessage<DuenoDto>> insert(@RequestBody DuenoDto request){
        log.debug("REST request to insert dueno: {}", request);
        ResponseMessage message = null;
        try {
            crudBusiness.insert(request);
            message = new ResponseMessage<>(200, "insertar, process successful", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }


    @Operation(summary = "List Dueno", description = "Proporciona una Dueño disponible.")
    @GetMapping("/Dueño/{id}")
    public ResponseEntity<ResponseMessage<DuenoDto>> findById(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            DuenoDto duenoO = crudBusiness.getId(id);

            message = new ResponseMessage<>(200, "findById, process successful ", duenoO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }



    @Operation(summary = "delete un dueño", description = "Elimina un dueño.")
    @DeleteMapping("/dueño/delete/{id}")
    public ResponseEntity<ResponseMessage<DuenoDto>> dalete(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate dueño : {}", id);
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
