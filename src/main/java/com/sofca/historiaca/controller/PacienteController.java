package com.sofca.historiaca.controller;

import com.sofca.historiaca.business.PacienteBusiness;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
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
@RequestMapping("/paciente")
@CrossOrigin
public class PacienteController {

    @Autowired
    private CrudBusiness<PacienteDto> crudBusiness;


    @Operation(summary = "List paciente", description = "Proporciona una lista de pacientes.")
    @GetMapping("/pacienteAll")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<PacienteDto> list = null;
        ResponseMessage message = null;
        try {
            list = this.crudBusiness.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }
        return ResponseEntity.ok(message);
    }




    @PostMapping("/savePaciente")
    public ResponseEntity<ResponseMessage<PacienteDto>> insert(@RequestBody PacienteDto request){
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


    @Operation(summary = "List paciente", description = "Proporciona un paciente disponible.")
    @GetMapping("/paciente/{id}")
    public ResponseEntity<ResponseMessage<PacienteDto>> findById(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate Planilla : {}", id);
        ResponseMessage message =null;
        try{
            PacienteDto mascotaO = crudBusiness.getId(id);

            message = new ResponseMessage<>(200, "findById, process successful ", mascotaO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }

    @Operation(summary = "delete un paciente", description = "Elimina un paciente.")
    @DeleteMapping("/paciente/delete/{id}")
    public ResponseEntity<ResponseMessage<PacienteDto>> dalete(@PathVariable("id") UUID id ) {
        log.debug("REST request to saveOrUpdate paciente : {}", id);
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
