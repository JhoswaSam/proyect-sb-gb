package com.oxihelp.oxihelp.modelo.Service;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario save(Usuario usuario);
    public void delete(Long id);
    public Usuario findByLoginAndPassword(String login,String password);
}
