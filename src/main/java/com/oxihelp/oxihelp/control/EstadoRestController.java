package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Estado;
import com.oxihelp.oxihelp.modelo.Service.IEstadoService;

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
public class EstadoRestController {
    @Autowired
    private IEstadoService estadoService;

    @GetMapping("/estados")
    public List<Estado> Listar(){
        return estadoService.findAll();
    }

    @GetMapping("/estado/{id}")
    public Estado mostrar(@PathVariable Long id){
        return estadoService.findById(id);
    }

    @PostMapping("/estado")
    @ResponseStatus(HttpStatus.CREATED)
    public Estado crear(@RequestBody Estado estado){
        return estadoService.save(estado);
    }

    @PutMapping("/estado/{id}")
    public Estado actualizar(@RequestBody Estado estado, @PathVariable Long id){
        Estado registroOriginal = estadoService.findById(id);
        // set and get for the original 
        return estadoService.save(registroOriginal);
    }

    @DeleteMapping("/estado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        estadoService.delete(id);
    }
}
