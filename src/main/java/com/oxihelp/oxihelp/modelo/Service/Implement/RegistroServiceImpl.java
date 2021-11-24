package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Registro;
import com.oxihelp.oxihelp.modelo.DAO.IRegistroDAO;
import com.oxihelp.oxihelp.modelo.Service.IRegistroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroServiceImpl implements IRegistroService {

    @Autowired
    private IRegistroDAO registroDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> findAll() {
        return (List<Registro>) registroDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Registro findById(Long id) {
        return registroDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Registro save(Registro registro) {
        return registroDAO.save(registro);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        registroDAO.deleteById(id);       
    }
    
}
