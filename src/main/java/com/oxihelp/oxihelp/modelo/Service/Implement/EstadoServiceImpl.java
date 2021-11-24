package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Estado;
import com.oxihelp.oxihelp.modelo.DAO.IEstadoDAO;
import com.oxihelp.oxihelp.modelo.Service.IEstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl implements IEstadoService{

    @Autowired
    private IEstadoDAO estadoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Estado> findAll() {
        return (List<Estado>) estadoDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Estado findById(Long id) {
        return estadoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Estado save(Estado estado) {
        return estadoDAO.save(estado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estadoDAO.deleteById(id);
    }
    
}
