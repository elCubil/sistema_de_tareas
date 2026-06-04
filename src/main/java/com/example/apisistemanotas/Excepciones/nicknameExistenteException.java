package com.example.apisistemanotas.Excepciones;

public class nicknameExistenteException extends RuntimeException{

    public nicknameExistenteException(String mensaje){
        super(mensaje);
    }

}
