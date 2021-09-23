package com.example.proyectoBackEnd.controller;

import com.example.proyectoBackEnd.dto.PacienteDTO;
import com.example.proyectoBackEnd.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping("/registrar")
    public ResponseEntity<PacienteDTO> crear(@RequestBody PacienteDTO paciente){
        return ResponseEntity.ok(service.guardar(paciente));
    }

    @GetMapping()
    public ResponseEntity<List<PacienteDTO>> consultarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Integer id) {

        PacienteDTO paciente = service.buscar(id);

        if(paciente != null){
            return ResponseEntity.ok(paciente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping()
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteDTO paciente) {
        ResponseEntity<PacienteDTO> response = null;

        if (paciente.getId() != null && service.buscar(paciente.getId()) != null)
            response = ResponseEntity.ok(service.guardar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (service.buscar(id) != null) {
            service.eliminar(id);
            response = ResponseEntity.ok("Eliminado correctamente");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
}
