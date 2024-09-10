package com.sofca.historiaca.controller;

import com.sofca.historiaca.business.MascotaBusiness;
import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.util.ResponseMessage;
import com.sofca.historiaca.util.crud.CrudBusiness;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/mascota")
@CrossOrigin
public class MascotaController {
    @Autowired
    private CrudBusiness<MascotaDto> crudBusiness;
    @Autowired
    private MascotaBusiness mascotaBusiness;

    @Operation(summary = "List mascota", description = "Proporciona una lista de mascotas.")
    @GetMapping()
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


    @PostMapping()
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
    @GetMapping("/{id}")
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
    @DeleteMapping("/{id}")
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

    @Operation(summary = "Exporta un listado de mascotas")
    @GetMapping("/exportar-excel")
    public ResponseEntity<byte[]> exportExcel() throws IOException {
        ByteArrayInputStream stream = null;
        try {
            stream = this.mascotaBusiness.exportExcel();
            byte[] bytes = stream.readAllBytes();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=mascotas.xlsx");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

            return ResponseEntity.ok().headers(headers).body(bytes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Inserta o actualiza un listado de mascotas desde un Excel")
    @PostMapping(value = "/importar-excel", consumes = "multipart/form-data")
    public ResponseEntity<ResponseMessage<String>> importExcel(@RequestParam("file") MultipartFile file) {
        try {
            mascotaBusiness.importExcel(file);
            ResponseMessage<String> message = new ResponseMessage<>(200, "El archivo ha sido importado correctamente.", null);
            return ResponseEntity.ok(message);

        } catch (IOException e) {
            ResponseMessage<String> message = new ResponseMessage<>(500, "Error al procesar el archivo: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);

        } catch (Exception e) {
            ResponseMessage<String> message = new ResponseMessage<>(400, "Ocurrió un error: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
}
