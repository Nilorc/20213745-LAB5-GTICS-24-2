package com.example.lab5_gtics.repository;
import com.example.lab5_gtics.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRespository extends JpaRepository<Persona, Integer> {

    // Encuentra todas las personas
    List<Persona> findAll();
}
