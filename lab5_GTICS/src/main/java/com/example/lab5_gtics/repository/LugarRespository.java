package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugarRespository extends JpaRepository<Lugar, Integer> {

    // Encuentra todos los lugares
    List<Lugar> findAll();


    // Elimina un lugar por ID
    void deleteById(Integer id);
}
