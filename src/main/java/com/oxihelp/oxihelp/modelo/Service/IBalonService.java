package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Balon;

public interface IBalonService {
    public List<Balon> findAll();
    public Balon findById(Long id);
    public Balon save(Balon balon);
    public void delete(Long id);
}
