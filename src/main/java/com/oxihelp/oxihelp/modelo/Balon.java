package com.oxihelp.oxihelp.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    
    @ManyToOne
    @JoinColumn(name = "perteneceAdministrador", referencedColumnName = "id")
    private Administrador perteneceAdministrador;

    @ManyToOne
    @JoinColumn(name = "perteneceRegistro" ,referencedColumnName = "id")
    private Registro perteneceRegistro ;

    @ManyToOne
    @JoinColumn(name = "tieneEstado", referencedColumnName = "id")
    private Estado tieneEstado;
    


    public Balon(){}
    public Balon(
        String capacidad,
        Administrador perteneceAdministrador,
        Registro perteneceRegistro,
        Estado tieneEstado
        ){
        this.capacidad = capacidad;
        this.perteneceAdministrador = perteneceAdministrador;
        this.perteneceRegistro = perteneceRegistro;
        this.tieneEstado = tieneEstado;
    }
    

    public long getId() {
        return id;
    }
    public String getCapacidad() {
        return capacidad;
    }
    public Administrador getPerteneceAdministrador() {
        return perteneceAdministrador;
    }
    public Registro getPerteneceRegistro() {
        return perteneceRegistro;
    }
    public Estado getTieneEstado() {
        return tieneEstado;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    public void setPerteneceAdministrador(Administrador perteneceAdministrador) {
        this.perteneceAdministrador = perteneceAdministrador;
    }
    public void setPerteneceRegistro(Registro perteneceRegistro) {
        this.perteneceRegistro = perteneceRegistro;
    }
    public void setTieneEstado(Estado tieneEstado) {
        this.tieneEstado = tieneEstado;
    }
}
