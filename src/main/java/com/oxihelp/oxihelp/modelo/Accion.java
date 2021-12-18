package com.oxihelp.oxihelp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "accion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
// @JsonIdentityReference(alwaysAsId = true)
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tieneAccion")
    // @JsonManagedReference(value = "jsonAccion")
    private List<Registro> registros;
    


    public Accion(){}
    public Accion(
        String nombre,
        List<Registro> registros
        ){
        this.nombre = nombre;
        this.registros = registros;
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public List<Registro> getRegistros() {
        if(this.registros == null){
            this.registros = new ArrayList<>();
        }
        return registros;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
