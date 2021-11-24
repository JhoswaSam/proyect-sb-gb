package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Estado;

public interface IEstadoService {
    public List<Estado> findAll();
    public Estado findById(Long id);
    public Estado save(Estado estado);
    public void delete(Long id);
}
