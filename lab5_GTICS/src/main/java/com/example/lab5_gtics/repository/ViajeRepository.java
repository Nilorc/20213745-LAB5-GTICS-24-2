package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    // Encuentra todos los viajes
    List<Viaje> findAll();

    // Elimina un viaje por ID
    void deleteById(Integer id);
}
