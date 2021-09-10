package com.example.clinicaDemo.controller;

import com.example.clinicaDemo.repository.impl.OdontologoDaoH2;
import com.example.clinicaDemo.model.Odontologo;
import com.example.clinicaDemo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    /*    private OdontologoService odontologoService =
            new OdontologoService(new OdontologoDaoH2());
*/
    @PostMapping("/registrar")
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscar(@PathVariable Integer id) {
        Odontologo odontologo = odontologoService.buscar(id).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscar(id).isPresent()) {
            odontologoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }




}


