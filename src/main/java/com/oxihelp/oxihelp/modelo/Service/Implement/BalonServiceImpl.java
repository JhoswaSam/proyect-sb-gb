package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Balon;
import com.oxihelp.oxihelp.modelo.DAO.IBalonDAO;
import com.oxihelp.oxihelp.modelo.Service.IBalonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalonServiceImpl implements IBalonService {

    @Autowired
    private IBalonDAO balonDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Balon> findAll() {
        return (List<Balon>) balonDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Balon findById(Long id) {
        return balonDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Balon save(Balon balon) {
        return balonDAO.save(balon);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        balonDAO.deleteById(id);
    }
}
