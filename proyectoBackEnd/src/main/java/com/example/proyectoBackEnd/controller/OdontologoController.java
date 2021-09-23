package com.example.proyectoBackEnd.controller;

import com.example.proyectoBackEnd.dto.OdontologoDTO;
import com.example.proyectoBackEnd.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*15-9-21 Funciona el crud en postman y en las vistas*/
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService service;

    @PostMapping("/registrar")
    public ResponseEntity<OdontologoDTO> crear(@RequestBody OdontologoDTO odontologo){
        return ResponseEntity.ok(service.guardar(odontologo));
    }

    @GetMapping()
    public ResponseEntity<Collection<OdontologoDTO>> consultarTodos(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Integer id) {

        OdontologoDTO odontologo = service.buscar(id);

        if(odontologo != null){
            return ResponseEntity.ok(odontologo);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody OdontologoDTO odontologo) {
        ResponseEntity<OdontologoDTO> response = null;

        if (odontologo.getId() != null && service.buscar(odontologo.getId()
       ) != null)

            response = ResponseEntity.ok(service.guardar(odontologo));
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
