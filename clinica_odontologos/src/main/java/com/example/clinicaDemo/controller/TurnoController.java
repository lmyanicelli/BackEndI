package com.example.clinicaDemo.controller;
import com.example.clinicaDemo.model.Turno;
import com.example.clinicaDemo.repository.impl.DomicilioDaoH2;
import com.example.clinicaDemo.repository.impl.OdontologoDaoH2;
import com.example.clinicaDemo.repository.impl.PacienteDaoH2;
import com.example.clinicaDemo.repository.impl.TurnoListRepository;
import com.example.clinicaDemo.service.OdontologoService;
import com.example.clinicaDemo.service.PacienteService;
import com.example.clinicaDemo.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    /*private TurnoService turnoService =
            new TurnoService(new TurnoListRepository());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new DomicilioDaoH2()));
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());
*/
    @PostMapping("/registrar")
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;

        if (pacienteService.buscar(turno.getPaciente().getId()).isPresent() && odontologoService.buscar(turno.getOdontologo().getId()).isPresent())
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (turnoService.buscar(id).isPresent()) { // Esta validacion no esta en el enunciado del ejericio, pero se las dejo para que la tengan.
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.actualizar(turno));

    }
}
