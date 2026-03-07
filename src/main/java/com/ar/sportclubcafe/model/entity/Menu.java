package com.ar.sportclubcafe.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table(name = "menus") // Es buena práctica nombrar la tabla en plural
public class Menu implements Serializable {
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(name = "imagen_url")
    private String imagenUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

}
