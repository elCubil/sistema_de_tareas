package com.example.apisistemanotas.Excepciones;

public class IdUsuarioNoEncontradoException extends RuntimeException{

    public IdUsuarioNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
