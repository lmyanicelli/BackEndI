package com.example.proyectoBackEnd.dto;

import com.example.proyectoBackEnd.model.Odontologo;
import com.example.proyectoBackEnd.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


public class TurnoDTO {

    private Integer id;
    private Date date;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;

    public TurnoDTO() {
    }

    public Integer getId() {
        return id;
    }

   /* public void setId(Integer id) {
        this.id = id;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public OdontologoDTO getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDTO odontologo) {
        this.odontologo = odontologo;
    }
}
