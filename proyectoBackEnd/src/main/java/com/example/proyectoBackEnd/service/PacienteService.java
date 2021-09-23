package com.example.proyectoBackEnd.service;

import com.example.proyectoBackEnd.dto.PacienteDTO;
import com.example.proyectoBackEnd.model.Paciente;
import com.example.proyectoBackEnd.repository.IDomicilioRepository;
import com.example.proyectoBackEnd.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

  //  @Autowired
    private IPacienteRepository repository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ModelMapper modelMapper;

    final static Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    public PacienteService(IPacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteDTO guardar(PacienteDTO paciente){
        return savePaciente(paciente);
    }

    private PacienteDTO savePaciente(PacienteDTO paciente) {
            Paciente newPaciente = mapper.convertValue(paciente,
                    Paciente.class);

         PacienteDTO newPacienteDTO =
                  mapper.convertValue(repository.saveAndFlush(newPaciente),
                  PacienteDTO.class);
            if(newPacienteDTO.getId() != null){
                logger.info("Paciente guardado correctamente");
                return newPacienteDTO;
            }else{
                logger.debug("Error al guardar un nuevo paciente");
                return null;
            }

    }

    public List<PacienteDTO> buscarTodos(){
        List<Paciente> pacientes =
                repository.findAll(Sort.by(Sort.Direction.DESC,"apellido"));
        return modelMapper.map(pacientes,
                new TypeToken<List<PacienteDTO>>() {}.getType());
    }

    public PacienteDTO buscar(Integer id){
        if(id != null){
            PacienteDTO pacienteDTO = mapper.convertValue(repository.findById(id), PacienteDTO.class);
            logger.info("Buscar paciente: " + pacienteDTO);
            return pacienteDTO;
        }else{
            logger.error("Error al buscar paciente con id null");
            return null;
        }


    }

    public void eliminar(Integer id){
        logger.info("Paciente eliminado correctamente");
        repository.deleteById(id);
    }

}
