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

@Entity
@Table(name = "estado")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "tieneEstado")
    private List<Balon> balons;

    public Estado(){}
    public Estado(
        String nombre,
        List<Balon> balons
        ){
        this.nombre = nombre;
        this.balons = balons;        
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
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
    public void setBalons(List<Balon> balons) {
        this.balons = balons;
    }


}
