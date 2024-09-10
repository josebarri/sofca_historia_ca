package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.DuenoDto;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class MascotaBusiness implements CrudBusiness<MascotaDto> {
    private CrudManager<MascotaDto> crudManager;
    @Autowired
    private CrudManager<PacienteDto> pacienteDtoCrudManager;
    public MascotaBusiness(CrudManager<MascotaDto> crudManager){
        this.crudManager = crudManager;
    }
    @Override
    @Transactional(readOnly = true)
    public List<MascotaDto> selectAll() throws BusinessException {
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
    public MascotaDto insert(MascotaDto mascotaDto) throws BusinessException {
        try{

            this.crudManager.insert(mascotaDto);
        }catch (ManagerException ex){
            throw new BusinessException(ex);
        }catch (Exception ex){
            throw new BusinessException(ex);
        }
        return mascotaDto;
    }

    @Override
    public void update(MascotaDto mascotaDto) throws BusinessException {

    }

    @Override
    @Transactional(readOnly = true)
    public MascotaDto getId(UUID id) throws BusinessException {
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
            Sheet sheet = workbook.createSheet("Listado de Masccotas"); //Nombre de la hoja en excel

            //Encabezados
            Row headerRow = sheet.createRow(0);
            Cell headerCell1 = headerRow.createCell(0);
            headerCell1.setCellValue("UUID");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Nombre");
            Cell headerCell3 = headerRow.createCell(2);
            headerCell3.setCellValue("Raza");
            Cell headerCell4 = headerRow.createCell(3);
            headerCell4.setCellValue("Especie");
            Cell headerCell5 = headerRow.createCell(4);
            headerCell5.setCellValue("Nombre Dueño");
            Cell headerCell6 = headerRow.createCell(5);
            headerCell6.setCellValue("Telefono");

            //Data
            List<MascotaDto> MascotaDtoList = this.crudManager.selectAll();

            //Valida si esta el array vacio
            if (MascotaDtoList.isEmpty()) {
                return new ByteArrayInputStream(new byte[0]);
            }

            //Se recorre el Array
            int rowNum = 1;
            for (MascotaDto mascota : MascotaDtoList) {
                Row row = sheet.createRow(rowNum++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(mascota.getId_mascota().toString());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(mascota.getNombre_mascota());
                Cell cell3 = row.createCell(2);
                cell3.setCellValue(mascota.getRaza());
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(mascota.getEspecie());
                Cell cell5 = row.createCell(4);
                cell5.setCellValue(mascota.getDuenoDto().getNombreDueño());
                Cell cell6 = row.createCell(5);
                cell6.setCellValue(mascota.getDuenoDto().getTelefono());
            }

            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            }
        } catch (ManagerException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MascotaDto> importExcel(MultipartFile file) throws IOException {
        List<MascotaDto> mascotas = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null){
                    Cell uuidCell = row.getCell(0);
                    String uuid = (uuidCell != null) ? uuidCell.getStringCellValue() : "";
                    MascotaDto mascotaDto = new MascotaDto();
                    if (uuid.isEmpty()){
                        mascotaDto.setNombre_mascota(row.getCell(1).getStringCellValue());
                        mascotaDto.setRaza(row.getCell(2).getStringCellValue());
                        mascotaDto.setEspecie(row.getCell(3).getStringCellValue());

                        Date date = row.getCell(4).getDateCellValue();
                        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        mascotaDto.setFnac_mascota(localDate);

                        DuenoDto duenoDto = new DuenoDto();
                        duenoDto.setId_Dueño(UUID.fromString(row.getCell(5).getStringCellValue()));
                        mascotaDto.setDuenoDto(duenoDto);
                        MascotaDto result = this.crudManager.insert(mascotaDto);
                        PacienteDto pacienteDto = new PacienteDto();
                        pacienteDto.setMascotaDto(result);
                        this.pacienteDtoCrudManager.insert(pacienteDto);
                    } else {
                        mascotaDto.setId_mascota(UUID.fromString(row.getCell(0).getStringCellValue()));
                        mascotaDto.setNombre_mascota(row.getCell(1).getStringCellValue());
                        mascotaDto.setRaza(row.getCell(2).getStringCellValue());
                        mascotaDto.setEspecie(row.getCell(3).getStringCellValue());

                        Date date = row.getCell(4).getDateCellValue();
                        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        mascotaDto.setFnac_mascota(localDate);

                        DuenoDto duenoDto = new DuenoDto();
                        duenoDto.setId_Dueño(UUID.fromString(row.getCell(5).getStringCellValue()));
                        mascotaDto.setDuenoDto(duenoDto);
                        this.crudManager.insert(mascotaDto);
                    }
                }
            }

        } catch (ManagerException e) {
            throw new RuntimeException(e);
        }

        return mascotas;
    }

}
