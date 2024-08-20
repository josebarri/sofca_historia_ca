package com.sofca.historiaca.dto;

public class EpsDto {
    private String id_eps ;
    private String nombre;
    private String direccion;
    private String fecha;
    private String telefono;

    public String getId_eps() {
        return id_eps;
    }

    public void setId_eps(String id_eps) {
        this.id_eps = id_eps;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
