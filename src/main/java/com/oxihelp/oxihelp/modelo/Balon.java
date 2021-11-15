package com.oxihelp.oxihelp.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "balon")
public class Balon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "capacidad")
    private String capacidad;
    @Column(name = "estado")
    private String estado;
    
    private Administrador perteneceAdministrador;
    private List<Registro> perteneRegistros;
    
    
}
