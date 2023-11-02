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
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity

public class Menu implements Serializable {
    @Id
    @Column(nullable=false, name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;
    private Double precio;
    private String nombre;
    private Date fechaRegistro;

}
