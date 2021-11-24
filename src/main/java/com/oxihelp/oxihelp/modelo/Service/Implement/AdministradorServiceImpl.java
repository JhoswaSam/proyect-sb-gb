package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Administrador;
import com.oxihelp.oxihelp.modelo.DAO.IAdministradorDAO;
import com.oxihelp.oxihelp.modelo.Service.IAdministradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdministradorServiceImpl implements IAdministradorService{

    @Autowired
    private IAdministradorDAO administradorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return (List<Administrador>) administradorDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador findById(Long id) {
        return administradorDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Administrador save(Administrador administrador) {
        return administradorDAO.save(administrador);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        administradorDAO.deleteById(id);
    }
    
}
