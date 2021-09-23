package com.example.proyectoBackEnd.service;

import com.example.proyectoBackEnd.dto.OdontologoDTO;
import com.example.proyectoBackEnd.model.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

//Revisar porque genera error el mapper
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
@SpringBootTest
public class OdontologoServiceTest {

/*
     static OdontologoService odontologoService =
            new OdontologoService();
     @Autowired
    ObjectMapper mapper;

    Odontologo odontologo = new Odontologo("Juan", "Pérez",12345678);
    OdontologoDTO odontologoDTO = new OdontologoDTO("Juan", "Pérez",12345678);

    @Test
    public void guardar() {
        OdontologoDTO odontologoDTOGuardar =
                odontologoService.guardar(odontologoDTO);
        Assert.assertTrue(odontologoDTOGuardar.getId()!=null);
        Assert.assertEquals("Juan", odontologoDTOGuardar.getNombre());

    }

    @Test
    public void getAll() {
    }

    @Test
    public void buscar() {
    }

    @Test
    public void eliminar() {
    }
/*
    private static OdontologoService odontologoService =
            new OdontologoService();

    private Odontologo odontologo = new Odontologo("Juan", "Pérez",12345678);

    @BeforeClass
    public static void cargarDataSet() {
        odontologoService.guardar(new Odontologo("Santiago", "Paz", 3455647));
    }

    @Test
    public void guardarOdontologo() {
        Odontologo odontologo = odontologoService.guardar(new Odontologo("Juan",
                "Ramirez", 348971960));
        Assert.assertTrue(odontologo.getId() != null);

    }
/*
    @Test
    void obtenerTodos() {
    }

    @Test
    void buscar() {
    }

    @Test
    void eliminar() {
    }*/
}