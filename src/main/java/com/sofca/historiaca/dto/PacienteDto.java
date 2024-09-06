package com.sofca.historiaca.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PacienteDto {
    private UUID idPaciente;
    private LocalDate fechaRegistro;
    private MascotaDto mascotaDto;

    public UUID getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(UUID idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public MascotaDto getMascotaDto() {
        return mascotaDto;
    }

    public void setMascotaDto(MascotaDto mascotaDto) {
        this.mascotaDto = mascotaDto;
    }
}
