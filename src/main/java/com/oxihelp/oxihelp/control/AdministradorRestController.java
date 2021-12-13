package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Administrador;
import com.oxihelp.oxihelp.modelo.Service.IAdministradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorRestController {
    @Autowired
    private IAdministradorService administradorService;

    @GetMapping("/administrador")
    public List<Administrador> Listar(){
        return administradorService.findAll();
    }

    @GetMapping("/administrador/{id}")
    public Administrador mostrar(@PathVariable Long id){
        return administradorService.findById(id);
    }

    @PostMapping("/administrador")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador crear(@RequestBody Administrador administrador){
        return administradorService.save(administrador);
    }

    @PutMapping("/administrador/{id}")
    public Administrador actualizar(@RequestBody Administrador administrador ,@PathVariable Long id){
        Administrador administradorOriginal = administradorService.findById(id);
        // set and get for the original 
        administradorOriginal.setNombre(administrador.getNombre());
        administradorOriginal.setApellido(administrador.getApellido());
        administradorOriginal.setBalons(administrador.getBalons());
        administradorOriginal.setTieneUsuario(administrador.getTieneUsuario());
        return administradorService.save(administradorOriginal);
    }

    @DeleteMapping("/administrador/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        administradorService.delete(id);
    }
}
