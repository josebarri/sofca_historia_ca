package com.sofca.historiaca.controller;

import com.sofca.historiaca.dto.DuenoDto;
import com.sofca.historiaca.dto.MascotaDto;
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
@RequestMapping("/mascota")
@CrossOrigin
public class MascotaController {
    @Autowired
    private CrudBusiness<MascotaDto> crudBusiness;

    @Operation(summary = "List mascota", description = "Proporciona una lista de mascotas.")
    @GetMapping("/mascotaAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<MascotaDto> list = null;
        ResponseMessage message = null;
        try {
            list = this.crudBusiness.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping("/saveMascota")
    public ResponseEntity<ResponseMessage<MascotaDto>> insert(@RequestBody MascotaDto request){
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


    @Operation(summary = "List Mascota", description = "Proporciona una Mascota disponible.")
    @GetMapping("/mascota/{id}")
    public ResponseEntity<ResponseMessage<MascotaDto>> findById(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            MascotaDto mascotaO = crudBusiness.getId(id);

            message = new ResponseMessage<>(200, "findById, process successful ", mascotaO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }


    @Operation(summary = "delete una mascota", description = "Elimina una mascota.")
    @DeleteMapping("/mascota/delete/{id}")
    public ResponseEntity<ResponseMessage<MascotaDto>> dalete(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate mascota : {}", id);
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
