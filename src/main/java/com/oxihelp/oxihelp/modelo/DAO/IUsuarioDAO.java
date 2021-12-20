package com.oxihelp.oxihelp.modelo.DAO;

import com.oxihelp.oxihelp.modelo.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
    Usuario findByLoginAndPassword(String login,String password);
}
