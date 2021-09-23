package com.example.proyectoBackEnd.controller;

import com.example.proyectoBackEnd.dto.TurnoDTO;
import com.example.proyectoBackEnd.model.Turno;
import com.example.proyectoBackEnd.service.OdontologoService;
import com.example.proyectoBackEnd.service.PacienteService;
import com.example.proyectoBackEnd.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REVISAR
@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    final static Logger logger = Logger.getLogger(TurnoController.class);

    @PostMapping("/registrar")
    public ResponseEntity<TurnoDTO> crear(@RequestBody TurnoDTO turno){
        ResponseEntity<TurnoDTO> response;
        TurnoDTO responseTurno = service.guardar(turno);

        if (responseTurno != null) {
            logger.info("Creando turno...");
            response = ResponseEntity.ok(responseTurno);

        }else {
            logger.info("Error al crear turno. Paciente u Odontologo null");
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return response;
    }

    @GetMapping()
    public ResponseEntity<List<TurnoDTO>> consultarTodos(){
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Integer id) {

        TurnoDTO turno = service.buscar(id);

        if(turno != null){
            return ResponseEntity.ok(turno);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping()
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turno) {
        ResponseEntity<TurnoDTO> response = null;

        if (turno.getId() != null && service.buscar(turno.getId()) != null)
            response = ResponseEntity.ok(service.guardar(turno));
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

   /* @GetMapping("/odontologo/{id}")
    public ResponseEntity<List<TurnoDTO>> findAllByOdontologoId(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPorOdontologo(id));
    }*/
}
