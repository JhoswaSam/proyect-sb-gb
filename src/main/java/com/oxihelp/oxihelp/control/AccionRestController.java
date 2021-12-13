package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Accion;
import com.oxihelp.oxihelp.modelo.Service.IAccionService;

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
public class AccionRestController {
    @Autowired
    private IAccionService accionService;

    @GetMapping("/accion")
    public List<Accion> Listar(){
        return accionService.findAll();
    }

    @GetMapping("/accion/{id}")
    public Accion mostrar(@PathVariable Long id){
        return accionService.findById(id);
    }

    @PostMapping("/accion")
    @ResponseStatus(HttpStatus.CREATED)
    public Accion crear(@RequestBody Accion accion){
        return accionService.save(accion);
    }

    @PutMapping("/accion/{id}")
    public Accion actualizar(@RequestBody Accion accion, @PathVariable Long id){
        Accion accionOriginal = accionService.findById(id);
        // set and get for the original 
        accionOriginal.setNombre(accion.getNombre());
        accionOriginal.setRegistros(accion.getRegistros());
        return accionService.save(accionOriginal);
    }

    @DeleteMapping("/accion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        accionService.delete(id);
    }
}
