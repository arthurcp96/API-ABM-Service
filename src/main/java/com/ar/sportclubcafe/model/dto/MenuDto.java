package com.ar.sportclubcafe.model.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder

public class MenuDto implements Serializable {
    
    private Integer idMenu;
    @NotEmpty(message="Precio requerido!")
    private Double precio;
    @Size(min =2, max = 25)
    @NotEmpty(message="Nombre requerido!")
    private String nombre;
    private Date fechaRegistro;
}
