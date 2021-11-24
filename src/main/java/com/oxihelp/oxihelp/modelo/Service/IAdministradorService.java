package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Administrador;


public interface IAdministradorService {
    public List<Administrador> findAll();
    public Administrador findById(Long id);
    public Administrador save(Administrador administrador);
    public void delete(Long id);
}
