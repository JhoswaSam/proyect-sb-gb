package com.oxihelp.oxihelp.modelo.DAO;

import com.oxihelp.oxihelp.modelo.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface IClienteDAO extends CrudRepository<Cliente, Long> {
    
}
