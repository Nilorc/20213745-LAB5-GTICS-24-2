package com.example.lab5_gtics.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "lugares")
@Getter
@Setter
public class Lugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares")
    private Integer id;

    @Column(name = "nombre_lugar")
    private String nombreLugar;

    @Column(name = "descrip_lugar")
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private String fechaLugar;

    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Viaje> viajes;
}
