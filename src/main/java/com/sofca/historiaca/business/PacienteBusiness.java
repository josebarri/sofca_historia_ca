package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.MascotaDto;
import com.sofca.historiaca.dto.PacienteDto;
import com.sofca.historiaca.exception.BusinessException;
import com.sofca.historiaca.exception.ManagerException;
import com.sofca.historiaca.util.crud.CrudBusiness;
import com.sofca.historiaca.util.crud.CrudManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public class PacienteBusiness implements CrudBusiness<PacienteDto> {
    private CrudManager<PacienteDto> crudManager;
    public PacienteBusiness(CrudManager<PacienteDto> crudManager){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<PacienteDto> selectAll() throws BusinessException {
        try{
            return this.crudManager.selectAll();
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public PacienteDto insert(PacienteDto pacienteDto) throws BusinessException {
        try{

            this.crudManager.insert(pacienteDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return pacienteDto;
    }

    @Override
    public void update(PacienteDto pacienteDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDto getId(UUID id) throws BusinessException {
        try {
            return this.crudManager.getId(id);
        } catch (ManagerException ex) {
            throw new BusinessException(ex);
        } catch (Exception ex) {
            throw new BusinessException(ex);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void deleteId(UUID id) throws BusinessException {
        try{
            this.crudManager.deleteId(id);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
    }

    public ByteArrayInputStream exportExcel() throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Listado de pacientes"); //Nombre de la hoja en excel

            //Encabezados
            Row headerRow = sheet.createRow(0);
            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("UUID paciente");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Nombre Mascota");
            Cell headerCell3 = headerRow.createCell(2);
            headerCell3.setCellValue("Raza");
            Cell headerCell4 = headerRow.createCell(3);
            headerCell4.setCellValue("Especie");
            Cell headerCell5 = headerRow.createCell(4);
            headerCell5.setCellValue("fecha nacimiento");
            Cell headerCell6 = headerRow.createCell(5);
            headerCell6.setCellValue("propietario");
            Cell headerCell7 = headerRow.createCell(6);
            headerCell7.setCellValue("Fecha Reistro");

            //Data
            List<PacienteDto> PacienteDtoList = this.crudManager.selectAll();

            //Valida si esta el array vacio
            if (PacienteDtoList.isEmpty()) {
                return new ByteArrayInputStream(new byte[0]);
            }

            //Se recorre el Array
            int rowNum = 1;
            for (PacienteDto paciente : PacienteDtoList) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(paciente.getIdPaciente().toString());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(paciente.getMascotaDto().getNombre_mascota());
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(paciente.getMascotaDto().getRaza());
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(paciente.getMascotaDto().getEspecie());
                Cell cell5 = row.createCell(4);
                cell5.setCellValue(paciente.getMascotaDto().getFnac_mascota());
                Cell cell6 = row.createCell(5);
                cell6.setCellValue(paciente.getMascotaDto().getDuenoDto().getNombreDueño());
                Cell cell7 = row.createCell(6);
                cell7.setCellValue(paciente.getFechaRegistro());
            }

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            }
        } catch (ManagerException e) {
            throw new RuntimeException(e);
        }
    }
}
