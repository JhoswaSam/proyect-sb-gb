package com.oxihelp.oxihelp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "administrador")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
// @JsonIdentityReference(alwaysAsId = true)
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "tieneUsuario", referencedColumnName = "id")
    // @JsonBackReference(value = "jsonUsuario")
    private Usuario tieneUsuario;

    @OneToMany(mappedBy = "perteneceAdministrador")
    // @JsonManagedReference(value = "jsonAdministrador")
    private List<Balon> balons;

    

    public Administrador(){}
    public Administrador(
        String nombre, 
        String apellido, 
        Usuario tieneUsuario,
        List<Balon> balons
        ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tieneUsuario = tieneUsuario;
        this.balons = balons;
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public Usuario getTieneUsuario() {
        return tieneUsuario;
    }
    public List<Balon> getBalons() {
        if(this.balons == null){
            this.balons = new ArrayList<>();
        }
        return balons;
    }



    public void setId(long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTieneUsuario(Usuario tieneUsuario) {
        this.tieneUsuario = tieneUsuario;
    }
    public void setBalons(List<Balon> balons) {
        this.balons = balons;
    }

}
