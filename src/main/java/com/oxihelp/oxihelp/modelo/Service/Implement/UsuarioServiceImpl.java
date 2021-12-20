package com.oxihelp.oxihelp.modelo.Service.Implement;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Usuario;
import com.oxihelp.oxihelp.modelo.DAO.IUsuarioDAO;
import com.oxihelp.oxihelp.modelo.Service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private IUsuarioDAO usuarioDAO;
        
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDAO.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        usuarioDAO.deleteById(id);
    }


    @Override
    public Usuario findByLoginAndPassword(String login, String password) {
        return (Usuario) usuarioDAO.findByLoginAndPassword(login, password);
    }
     
}
