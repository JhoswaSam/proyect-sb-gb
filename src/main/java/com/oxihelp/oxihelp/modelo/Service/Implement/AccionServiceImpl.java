package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Accion;
import com.oxihelp.oxihelp.modelo.DAO.IAccionDAO;
import com.oxihelp.oxihelp.modelo.Service.IAccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccionServiceImpl implements IAccionService{

    @Autowired
    private IAccionDAO accionDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Accion> findAll() {
        return (List<Accion>) accionDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Accion findById(Long id) {
        return accionDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Accion save(Accion accion) {
        return accionDAO.save(accion);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        accionDAO.deleteById(id);
    }
    
}
