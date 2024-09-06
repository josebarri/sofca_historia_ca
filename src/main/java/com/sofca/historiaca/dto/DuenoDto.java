package com.sofca.historiaca.dto;

import java.util.UUID;

public class DuenoDto {
    private UUID id_Dueño;
    private String nombreDueño;
    private String apellidoDueño;
    private String telefono;
    private String  num_identificacion;
    private TipoIdentificacionDto tipoIdentificacionDto;
    private UbicacionDto ubicacionDto;

    public String getNum_identificacion() {
        return num_identificacion;
    }

    public void setNum_identificacion(String num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public UUID getId_Dueño() {
        return id_Dueño;
    }

    public void setId_Dueño(UUID id_Dueño) {
        this.id_Dueño = id_Dueño;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getApellidoDueño() {
        return apellidoDueño;
    }

    public void setApellidoDueño(String apellidoDueño) {
        this.apellidoDueño = apellidoDueño;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoIdentificacionDto getTipoIdentificacionDto() {
        return tipoIdentificacionDto;
    }

    public void setTipoIdentificacionDto(TipoIdentificacionDto tipoIdentificacionDto) {
        this.tipoIdentificacionDto = tipoIdentificacionDto;
    }

    public UbicacionDto getUbicacionDto() {
        return ubicacionDto;
    }

    public void setUbicacionDto(UbicacionDto ubicacionDto) {
        this.ubicacionDto = ubicacionDto;
    }
}
