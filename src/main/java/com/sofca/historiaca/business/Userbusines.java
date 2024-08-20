package com.sofca.historiaca.business;

import com.sofca.historiaca.dto.UserDto;
import com.sofca.historiaca.manager.UserManager;



public class Userbusines {
    private UserManager userManager;
    public Userbusines(){
        UserManager userManager = new UserManager();
    }


    public void registraruser(UserDto userDto){
        if (userDto != null){
            userManager.registrar(userDto);
        }
    }
}
