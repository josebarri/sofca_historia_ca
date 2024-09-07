package com.sofca.historiaca.controller;

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
@RequestMapping("/tipoIdent")
@CrossOrigin
public class TipoIdentificacionController {
    @Autowired
    private CrudBusiness<TipoIdentificacionDto> crudBusiness;

    @Operation(summary = "List TipoIdentificacion", description = "Proporciona una lista de identificaciones.")
    @GetMapping("/tipoIdentAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<TipoIdentificacionDto> list = null;
        ResponseMessage message = null;
        try {
            list = this.crudBusiness.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }



    @PostMapping("/saveTipoIdent")
    public ResponseEntity<ResponseMessage<TipoIdentificacionDto>> insert(@RequestBody TipoIdentificacionDto request){
        log.debug("REST request to insert TipoIdentificacion: {}", request);
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
    @GetMapping("/tipoIdent/{id}")
    public ResponseEntity<ResponseMessage<TipoIdentificacionDto>> findById(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            TipoIdentificacionDto tipoIdentO = crudBusiness.getId(id);

            message = new ResponseMessage<>(200, "findById, process successful ", tipoIdentO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }



    @Operation(summary = "delete tipo identificacion", description = "Elimina un tipo identificacion.")
    @DeleteMapping("/tipoIdent/delete/{id}")
    public ResponseEntity<ResponseMessage<TipoIdentificacionDto>> dalete(@PathVariable("id") UUID id ) {
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
