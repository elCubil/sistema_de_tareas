package com.example.apisistemanotas.Excepciones;

import org.springframework.data.jpa.repository.JpaRepository;

public class IdUsuarioOrigenNoAsignadoIdTask extends RuntimeException{

    public IdUsuarioOrigenNoAsignadoIdTask(String mensaje){
        super(mensaje);
    }

}
