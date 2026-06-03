package com.example.apisistemanotas.Model;

import jakarta.persistence.*;

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
    //usuario en el nombre del atributo
    //se usa joinColumn en un atributo envuelto en relacion
    @JoinColumn(name="usuario_id")
    @ManyToOne
    private User usuario;
}
