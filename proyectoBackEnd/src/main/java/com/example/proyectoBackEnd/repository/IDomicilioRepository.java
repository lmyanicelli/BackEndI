package com.example.proyectoBackEnd.repository;

import com.example.proyectoBackEnd.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,
        Integer> {
}
