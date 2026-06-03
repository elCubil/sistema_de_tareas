package com.example.apisistemanotas.DTO;

import com.example.apisistemanotas.Model.Task;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RequestCreacionUser {




    private String nombre;

    private String apellido;

    private Integer edad;




}
