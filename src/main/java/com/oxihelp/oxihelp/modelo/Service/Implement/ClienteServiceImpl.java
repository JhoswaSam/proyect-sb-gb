package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Cliente;
import com.oxihelp.oxihelp.modelo.DAO.IClienteDAO;
import com.oxihelp.oxihelp.modelo.Service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDAO clienteDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDAO.deleteById(id);      
    }

    @Override
    public Cliente findByDNI(String dni) {
        return clienteDAO.findByDNI(dni);
    }
    
}
