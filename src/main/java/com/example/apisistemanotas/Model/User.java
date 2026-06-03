package com.example.apisistemanotas.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    private String apellido;

    private Integer edad;

    //el termino en mappedBy debe coincidir con el nombre de atributo en la entidad del
    //lado many
    @OneToMany(mappedBy="usuario")
    private List<Task> tareas;

    private LocalDateTime CreatedAt;


}
