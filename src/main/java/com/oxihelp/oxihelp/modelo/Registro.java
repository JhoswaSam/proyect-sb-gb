package com.oxihelp.oxihelp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @OneToMany(mappedBy = "perteneceRegistro")
    @JsonManagedReference(value = "jsonRegistro")
    private List<Balon> balons;

    @ManyToOne
    @JoinColumn(name = "perteneceCliente", referencedColumnName = "id")
    @JsonBackReference(value = "jsonCliente")
    private Cliente perteneceCliente;

    @ManyToOne
    @JoinColumn(name = "tieneAccion", referencedColumnName = "id")
    @JsonBackReference(value = "jsonAccion")
    private Accion tieneAccion;



    public Registro(){}
    public Registro(
        String fechaEntrega, 
        String fechaDevolucion,
        List<Balon> balons,
        Cliente perteneceCliente,
        Accion tieneAccion
        ){
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion= fechaDevolucion;
        this.balons = balons;
        this.perteneceCliente = perteneceCliente;
        this.tieneAccion = tieneAccion;
    }

    public long getId() {
        return id;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
    public List<Balon> getBalons() {
        if(this.balons == null){
            this.balons = new ArrayList<>();
        }
        return balons;
    }
    public Cliente getPerteneceCliente() {
        return perteneceCliente;
    }
    public Accion getTieneAccion() {
        return tieneAccion;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public void setBalons(List<Balon> balons) {
        this.balons = balons;
    }
    public void setPerteneceCliente(Cliente perteneceCliente) {
        this.perteneceCliente = perteneceCliente;
    }
    public void setTieneAccion(Accion tieneAccion) {
        this.tieneAccion = tieneAccion;
    }
}
