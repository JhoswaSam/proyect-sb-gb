package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Accion;

public interface IAccionService {
    public List<Accion> findAll();
    public Accion findById(Long id);
    public Accion save(Accion accion);
    public void delete(Long id);
}
