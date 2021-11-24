package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Usuario;
import com.oxihelp.oxihelp.modelo.Service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;


    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario mostrar(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioOriginal = usuarioService.findById(id);
        usuarioOriginal.setLogin(usuario.getLogin());
        return usuarioService.save(usuarioOriginal);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        usuarioService.delete(id);
    }
}
