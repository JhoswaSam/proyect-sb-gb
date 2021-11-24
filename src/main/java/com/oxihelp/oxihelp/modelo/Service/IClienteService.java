package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Cliente;

public interface IClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);
}
