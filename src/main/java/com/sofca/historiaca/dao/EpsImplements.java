package com.sofca.historiaca.dao;

import com.sofca.historiaca.dto.EpsDto;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EpsImplements implements EpsI {
    @Override
    public List<EpsDto> listarEps() {
        List<EpsDto> eps = new ArrayList<>();
        EpsDto epsDto = new EpsDto();
        epsDto.setId_eps("01");
        epsDto.setNombre("EPS Salud Vida");
        epsDto.setDireccion("Calle 123");
        epsDto.setFecha("2024-08-19");
        epsDto.setTelefono("123456789");

        EpsDto eps2 = new EpsDto();
        eps2.setId_eps("002");
        eps2.setNombre("EPS Bienestar");
        eps2.setDireccion("Avenida Siempre Viva");
        eps2.setFecha("2024-08-19");
        eps2.setTelefono("987654321");

        EpsDto eps3 = new EpsDto();
        eps3.setId_eps("003");
        eps3.setNombre("EPS la mas");
        eps3.setDireccion("sahagun");
        eps3.setFecha("2024-08-19");
        eps3.setTelefono("3156658467");
        eps.add(eps3);
        eps.add(eps2);
        eps.add(epsDto);
        return eps;
    }

    @Override
    public EpsDto slectById(String id) {
        for (EpsDto eps : listarEps()) {
            if (eps.getId_eps().equals(id)) {
                return eps;
            }
        }
        return null;
    }

    @Override
    public boolean dleteEps(String id) {
        Iterator<EpsDto> iterator = listarEps().iterator();
        while (iterator.hasNext()) {
            EpsDto eps = iterator.next();
            if (eps.getId_eps().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public EpsDto filtroName(String nombre) {
        for (EpsDto eps : listarEps()) {
            if (eps.getNombre().equals(nombre)) {
                return eps;
            }
        }
        return null;
    }

    @Override
    public List<EpsDto> selectAll() throws Exception {
        List<EpsDto> eps = new ArrayList<>();
        return eps;
    }

    @Override
    public void InsertEps(EpsDto epsDto) throws Exception {

    }

    @Override
    public void EditEps(EpsDto epsDto) throws Exception {

    }

    @Override
    public void DeleteEps(Integer identidad) throws Exception {

    }

    @Override
    public EpsDto EpsID(Integer identidad) throws Exception {
        return null;
    }
}
