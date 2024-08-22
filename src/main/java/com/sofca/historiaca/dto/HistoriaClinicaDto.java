package com.sofca.historiaca.dto;

import java.sql.Date;

public class HistoriaClinicaDto {
    private String  id_historial;
    private String cc_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private String fn_paciente;
    private String genero_paciente;
    private String  direccion_paciente;
    private String  telefono_paciente;
    private String correo_paciente;
    private String nombre_medico;
    private String apellido_medico;
    private String  especialidad_medico;
    private String  diagnostico;
    private String  tratamiento ;
    private String fecha_creacion;
    private String  observaciones;
    private EpsDto epsDto;

    public String getId_historial() {
        return id_historial;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
    }

    public String getCc_paciente() {
        return cc_paciente;
    }

    public void setCc_paciente(String cc_paciente) {
        this.cc_paciente = cc_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public String getFn_paciente() {
        return fn_paciente;
    }

    public void setFn_paciente(String fn_paciente) {
        this.fn_paciente = fn_paciente;
    }

    public String getGenero_paciente() {
        return genero_paciente;
    }

    public void setGenero_paciente(String genero_paciente) {
        this.genero_paciente = genero_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public String getNombre_medico() {
        return nombre_medico;
    }

    public void setNombre_medico(String nombre_medico) {
        this.nombre_medico = nombre_medico;
    }

    public String getApellido_medico() {
        return apellido_medico;
    }

    public void setApellido_medico(String apellido_medico) {
        this.apellido_medico = apellido_medico;
    }

    public String getEspecialidad_medico() {
        return especialidad_medico;
    }

    public void setEspecialidad_medico(String especialidad_medico) {
        this.especialidad_medico = especialidad_medico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EpsDto getEpsDto() {
        return epsDto;
    }

    public void setEpsDto(EpsDto epsDto) {
        this.epsDto = epsDto;
    }
}
