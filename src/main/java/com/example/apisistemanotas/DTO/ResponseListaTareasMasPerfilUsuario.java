package com.example.apisistemanotas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class ResponseListaTareasMasPerfilUsuario {
    private Long id;


    private String nickname;

    private List<ResponseListaTareas> tareas;

}
