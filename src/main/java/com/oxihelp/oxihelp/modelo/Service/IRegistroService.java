package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Registro;

public interface IRegistroService {
    public List<Registro> findAll();
    public Registro findById(Long id);
    public Registro save(Registro registro);
    public void delete(Long id);
}
