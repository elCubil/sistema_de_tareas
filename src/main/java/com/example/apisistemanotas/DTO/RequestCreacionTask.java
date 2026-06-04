package com.example.apisistemanotas.DTO;

import com.example.apisistemanotas.Model.Dificultad;
import com.example.apisistemanotas.Model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class RequestCreacionTask {


    @NotNull
    @NotBlank
    private String tarea;

    @NotNull
    private Dificultad nivel;

    @NotNull
    //@NotBlank es solo para string
    private Long userId;




}
