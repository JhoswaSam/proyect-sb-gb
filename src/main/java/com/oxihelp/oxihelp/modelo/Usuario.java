package com.oxihelp.oxihelp.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;


    @OneToOne(mappedBy = "tieneUsuario")
    @JsonManagedReference(value = "jsonUsuario")
    private Administrador administrador;


    
    public Usuario(){ }
    public Usuario(
        String login, 
        String password,
        Administrador administrador
        ){ 
        this.login = login;
        this.password = password;
        this.administrador = administrador;
    }

    public long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public Administrador getAdministrador() {
        return administrador;
    }


    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
