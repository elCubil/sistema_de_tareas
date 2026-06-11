package com.example.apisistemanotas.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tarea;

    @Column(name="descripcion")
    //se usa columna en un atributo que no participa de relacion
    @Enumerated(EnumType.STRING)
    private Dificultad nivel;

    //joinColumn indica el nombre del campo en la BD
    //usuario es el nombre del atributo
    //se usa joinColumn en un atributo envuelto en relacion
    @JoinColumn(name="usuario_id")
    @ManyToOne
    private User usuario;

    private LocalDateTime createdAt;


}
