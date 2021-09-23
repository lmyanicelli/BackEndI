package com.example.proyectoBackEnd.service;

import com.example.proyectoBackEnd.dto.DomicilioDTO;
import com.example.proyectoBackEnd.model.Domicilio;
import com.example.proyectoBackEnd.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DomicilioService {

    @Autowired
    IDomicilioRepository repository;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    ModelMapper modelMapper;

    public DomicilioDTO guardar(DomicilioDTO domicilio){
        return saveDomicilio(domicilio);
    }

    private DomicilioDTO saveDomicilio(DomicilioDTO domicilio) {
        Domicilio newDomicilio = mapper.convertValue(domicilio,
                Domicilio.class);
        DomicilioDTO newDomicilioDTO =
                mapper.convertValue(repository.save(newDomicilio),
                        DomicilioDTO.class);
        if(newDomicilioDTO.getId() != null){
            return newDomicilioDTO;
        }else{
            return null;
        }
    }

    public List<DomicilioDTO> obtenerTodos(){
        Collection<Domicilio> domicilios =
                repository.findAll();
        return modelMapper.map(domicilios,
                new TypeToken<List<DomicilioDTO>>() {}.getType());
    }

    public DomicilioDTO buscar(Integer id){
        return mapper.convertValue(repository.findById(id),
                DomicilioDTO.class);
    }

    public void eliminar(Integer id){
        repository.deleteById(id);
    }

}
