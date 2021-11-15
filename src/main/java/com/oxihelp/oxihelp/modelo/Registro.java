package com.oxihelp.oxihelp.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "fechaEntrega")
    private String fechaEntrega;
    @Column(name = "fechaDevolucion")
    private String fechaDevolucion;

    
    private List<Balon> tieneBalon;
    private Cliente perteneCliente;
    private Accion tieneAccion;

  
}
