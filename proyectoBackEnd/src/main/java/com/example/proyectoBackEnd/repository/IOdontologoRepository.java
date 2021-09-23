package com.example.proyectoBackEnd.repository;

import com.example.proyectoBackEnd.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,
        Integer> {

    @Query("FROM Odontologo o WHERE o.nombre = ?1 ORDER BY o.apellido")
    List<Odontologo> findByName(String name);
}
