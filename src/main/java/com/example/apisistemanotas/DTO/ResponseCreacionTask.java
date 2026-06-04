package com.example.apisistemanotas.DTO;

import com.example.apisistemanotas.Model.Dificultad;
import com.example.apisistemanotas.Model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
public class ResponseCreacionTask {


    private Long id;

    private String tarea;

    private Dificultad nivel;


    private User usuario;


}
