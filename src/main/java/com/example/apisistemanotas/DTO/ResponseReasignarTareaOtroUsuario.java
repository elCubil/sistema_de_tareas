package com.example.apisistemanotas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ResponseReasignarTareaOtroUsuario {
    private Long id;
    private Long userId;
    private String tarea;
}
