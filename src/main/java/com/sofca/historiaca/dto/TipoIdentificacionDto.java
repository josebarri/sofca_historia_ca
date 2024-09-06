package com.sofca.historiaca.dto;

import java.util.UUID;

public class TipoIdentificacionDto {
    private UUID idIdentificacion;
    private String tipo;

    public UUID getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(UUID idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
