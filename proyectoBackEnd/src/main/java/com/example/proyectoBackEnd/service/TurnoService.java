package com.example.proyectoBackEnd.service;

import com.example.proyectoBackEnd.dto.PacienteDTO;
import com.example.proyectoBackEnd.dto.TurnoDTO;
import com.example.proyectoBackEnd.model.Paciente;
import com.example.proyectoBackEnd.model.Turno;
import com.example.proyectoBackEnd.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

 //   @Autowired
    private ITurnoRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    final static Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    public TurnoService(ITurnoRepository repository) {
        this.repository = repository;
    }

    public TurnoDTO guardar(TurnoDTO turno){

        return saveTurno(turno);
    }

    private TurnoDTO saveTurno(TurnoDTO turno) {

        Turno newTurno = mapper.convertValue(turno,
                Turno.class);

        logger.info(newTurno);
        Turno response;
        try{
            response = repository.save(newTurno);
            logger.info("Turno guardado correctamente");
            return mapper.convertValue(response, TurnoDTO.class);

        }catch(Exception e){
            System.out.println(e);
            logger.error("Error al guardar un nuevo turno");
            return null;
        }
    }

    public List<TurnoDTO> obtenerTodos(){
        return modelMapper.map(repository.findAll(),
                new TypeToken<List<TurnoDTO>>() {}.getType());
    }

    public TurnoDTO buscar(Integer id){
        return mapper.convertValue(repository.findById(id), TurnoDTO.class);
    }

    public void eliminar(Integer id){
        repository.deleteById(id);
    }
/*
    public List<TurnoDTO> buscarPorOdontologo (Integer id){
        return modelMapper.map(repository.findAllByOdontologoId(id),
                new TypeToken<List<TurnoDTO>>() {}.getType());
    }*/
}
