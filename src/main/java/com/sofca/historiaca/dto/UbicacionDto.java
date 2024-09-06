package com.sofca.historiaca.dto;

import java.util.UUID;

public class UbicacionDto {
    private UUID idUbicacion;
    private String ciudad;
    private String direccion;

    public UUID getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(UUID idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
