package com.sofca.historiaca.manager;

import com.sofca.historiaca.dto.UserDto;



public class UserManager {
    public void  registrar(UserDto userDto){
        System.out.println("se registro el usuario:"+"/n"+userDto.getNombre());
    }
}
