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
    private List<Balon> balons;

    @ManyToOne
    @JoinColumn(name = "solicitaRegistro", referencedColumnName = "id")
    private Cliente solicitaRegistro;

    @ManyToOne
    @JoinColumn(name = "tieneAccion", referencedColumnName = "id")
    private Accion tieneAccion;



    public Registro(){}
    public Registro(
        String fechaEntrega, 
        String fechaDevolucion,
        List<Balon> balons,
        Cliente solicitaRegistro,
        Accion tieneAccion
        ){
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion= fechaDevolucion;
        this.balons = balons;
        this.solicitaRegistro = solicitaRegistro;
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
    public Cliente getSolicitaRegistro() {
        return solicitaRegistro;
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
    public void setSolicitaRegistro(Cliente solicitaRegistro) {
        this.solicitaRegistro = solicitaRegistro;
    }
    public void setTieneAccion(Accion tieneAccion) {
        this.tieneAccion = tieneAccion;
    }
}
