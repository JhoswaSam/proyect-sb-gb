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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "celular")
    private String celular;
    @Column(name = "domicilio")
    private String domicilio;
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;

    @OneToMany(mappedBy = "perteneceCliente")
    @JsonIgnore
    private List<Registro> registros;



    public Cliente(){}
    public Cliente(
        String nombre, 
        String apellidos, 
        String DNI, 
        String celular, 
        String domicilio,
        String fechaNacimiento,
        List<Registro> registros
        ){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.celular = celular;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.registros = registros;
    }

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getDNI() {
        return DNI;
    }
    public String getCelular() {
        return celular;
    }public String getDomicilio() {
        return domicilio;
    }public String getFechaNacimiento() {
        return fechaNacimiento;
    }public List<Registro> getRegistros() {
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
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }



}
