package com.example.proyectoBackEnd.controller;

import com.example.proyectoBackEnd.dto.DomicilioDTO;
import com.example.proyectoBackEnd.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    DomicilioService service;

    @PostMapping("/registrar")
    public ResponseEntity<DomicilioDTO> crear(@RequestBody DomicilioDTO domicilio){
        return ResponseEntity.ok(service.guardar(domicilio));
    }

    @GetMapping()
    public ResponseEntity<List<DomicilioDTO>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> buscar(@PathVariable Integer id) {

        DomicilioDTO domicilio = service.buscar(id);

        if(domicilio != null){
            return ResponseEntity.ok(domicilio);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping()
    public ResponseEntity<DomicilioDTO> actualizar(@RequestBody DomicilioDTO domicilio) {
        ResponseEntity<DomicilioDTO> response = null;

        if (domicilio.getId() != null && service.buscar(domicilio.getId()) != null)
            response = ResponseEntity.ok(service.guardar(domicilio));
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
