package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;

import java.util.List;

public interface EpsI {
    public List<EpsDto> listarEps();
    public EpsDto slectById(String id);
    public boolean dleteEps(String id);

    public EpsDto filtroName(String nombre);
}
