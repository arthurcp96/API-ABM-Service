package com.ar.sportclubcafe.model.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder

public class MenuDto implements Serializable {
    
    private Integer idMenu;
    private Double precio;
    private String nombre;
    private Date fechaRegistro;
}
