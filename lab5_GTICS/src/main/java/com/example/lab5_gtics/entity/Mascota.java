package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mascotas")
@Getter
@Setter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas")
    private Integer id;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    @Column
    private String genero;

    @Column
    private String edad;

    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;

    @Column
    private String vacunado;

    @Column
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona", nullable = false)
    private Persona persona;
}
