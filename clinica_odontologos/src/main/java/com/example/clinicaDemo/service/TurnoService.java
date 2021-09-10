package com.example.clinicaDemo.service;
import com.example.clinicaDemo.model.Turno;
import com.example.clinicaDemo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private IDao<Turno> turnoRepository;

    public TurnoService(IDao<Turno> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno){
        return  turnoRepository.guardar(turno);
    }
    public List<Turno> listar(){
        return turnoRepository.buscarTodos();
    }
    public void eliminar(Integer id){
        turnoRepository.eliminar(id);
    }
    public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    }
    public Optional<Turno> buscar(Integer id){
        return turnoRepository.buscar(id);
    }
}
