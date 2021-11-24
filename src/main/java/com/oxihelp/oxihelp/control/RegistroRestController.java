package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Registro;
import com.oxihelp.oxihelp.modelo.Service.IRegistroService;

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
public class RegistroRestController {
    @Autowired
    private IRegistroService registroService;

    @GetMapping("/registros")
    public List<Registro> Listar(){
        return registroService.findAll();
    }

    @GetMapping("/registro/{id}")
    public Registro mostrar(@PathVariable Long id){
        return registroService.findById(id);
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public Registro crear(@RequestBody Registro registro){
        return registroService.save(registro);
    }

    @PutMapping("/registro/{id}")
    public Registro actualizar(@RequestBody Registro registro, @PathVariable Long id){
        Registro registroOriginal = registroService.findById(id);
        // set and get for the original 
        return registroService.save(registroOriginal);
    }

    @DeleteMapping("/registro/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        registroService.delete(id);
    }
}
