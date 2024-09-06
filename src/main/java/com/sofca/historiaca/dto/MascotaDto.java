package com.sofca.historiaca.dto;

import java.time.LocalDate;
import java.util.UUID;

public class MascotaDto {
    private UUID id_mascota ;
    private String nombre_mascota;
    private String raza;
    private String especie;
    private LocalDate fnac_mascota;

    private DuenoDto duenoDto;

    public UUID getId_mascota() {
        return id_mascota;
    }

    public DuenoDto getDuenoDto() {
        return duenoDto;
    }

    public void setDuenoDto(DuenoDto duenoDto) {
        this.duenoDto = duenoDto;
    }

    public void setId_mascota(UUID id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFnac_mascota() {
        return fnac_mascota;
    }

    public void setFnac_mascota(LocalDate fnac_mascota) {
        this.fnac_mascota = fnac_mascota;
    }
}
