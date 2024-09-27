package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRespository extends JpaRepository<Mascota, Integer> {
    List<Mascota> findAll();
}
