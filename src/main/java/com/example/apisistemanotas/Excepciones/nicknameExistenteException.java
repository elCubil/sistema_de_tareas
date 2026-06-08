package com.example.apisistemanotas.Excepciones;

public class NicknameExistenteException extends RuntimeException{

    public NicknameExistenteException(String mensaje){
        super(mensaje);
    }

}
