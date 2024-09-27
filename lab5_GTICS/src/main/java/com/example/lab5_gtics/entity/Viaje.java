package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "viajes")
@Getter
@Setter
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes")
    private Integer id;

    @Column(name = "punto_recojo")
    private String puntoRecojo;

    @Column(name = "cant_personas")
    private String cantPersonas;

    @Column(name = "cant_perros")
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares", nullable = false)
    private Lugar lugar;
}
