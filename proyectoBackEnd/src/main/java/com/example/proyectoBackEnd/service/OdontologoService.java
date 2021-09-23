package com.example.proyectoBackEnd.service;

import com.example.proyectoBackEnd.dto.OdontologoDTO;
import com.example.proyectoBackEnd.model.Odontologo;
import com.example.proyectoBackEnd.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OdontologoService {

   // @Autowired
    private IOdontologoRepository repository;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ModelMapper modelMapper;

    final static Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    public OdontologoService(IOdontologoRepository repository) {
        this.repository = repository;
    }

    public OdontologoDTO guardar(OdontologoDTO odontologo){
        return saveOdontologo(odontologo);
    }

    private OdontologoDTO saveOdontologo(OdontologoDTO odontologoDTO) {
    Odontologo newOdontologo = mapper.convertValue(odontologoDTO,
            Odontologo.class);
    OdontologoDTO newOdontologoDTO =
            mapper.convertValue(repository.save(newOdontologo),
                    OdontologoDTO.class);
        if(newOdontologoDTO.getId() != null){
            logger.info("Odontologo guardado correctamente: " + newOdontologoDTO);
            return newOdontologoDTO;
        }else{
            logger.debug("Error al guardar el odontologo: " + odontologoDTO);
            return null;
        }
    }

    public Collection<OdontologoDTO> getAll() {
        Collection <Odontologo> odontologos =
                repository.findAll(Sort.by(Sort.Direction.DESC,"apellido"));
        return modelMapper.map(odontologos,
                new TypeToken<List<OdontologoDTO>>() {}.getType());
    }

    public OdontologoDTO buscar(Integer id){
        if(id != null) {
            return mapper.convertValue(repository.findById(id),
                    OdontologoDTO.class);
        }else{
            return null;
        }
    }

    public void eliminar(Integer id){
        logger.info("Odontologo eliminado correctamente");
        repository.deleteById(id);
    }

}
