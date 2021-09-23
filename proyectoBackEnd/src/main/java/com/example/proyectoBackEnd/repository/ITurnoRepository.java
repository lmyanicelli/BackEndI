package com.example.proyectoBackEnd.repository;

import com.example.proyectoBackEnd.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer> {

    //Ver error de dependencias al intentar estas query
  /*  @Query("from Turno t where t.id_odontologo = ?1")
    List<Turno> findAllByOdontologoId(Integer id);

    @Query("from Turno t where t.id_paciente = ?1")
    List<Turno>  findAllByPacienteId(Integer id);*/
}
