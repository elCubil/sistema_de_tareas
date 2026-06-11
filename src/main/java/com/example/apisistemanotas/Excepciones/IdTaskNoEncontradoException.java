package com.example.apisistemanotas.Excepciones;

public class IdTaskNoEncontradoException extends RuntimeException{
    public IdTaskNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
