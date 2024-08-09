package com.ar.sportclubcafe.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity

public class Menu implements Serializable {
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    @Column(nullable = false)
    private Double precio;
    @Column(nullable = false, unique = true)
    private String nombre;
    private Date fechaRegistro;

}
