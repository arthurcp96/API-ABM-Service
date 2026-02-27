package com.ar.sportclubcafe.model.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Builder

public class MenuDto implements Serializable {
    
    private Integer idMenu;
    @NotNull(message="Precio requerido!")
    private Double precio;
    @Size(min =2, max = 25)
    @NotEmpty(message="Nombre requerido!")
    private String nombre;
    private Date fechaRegistro;

/*     // Explicit getters and setters for JDK 25 compatibility
    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } */
}
