package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Balon;
import com.oxihelp.oxihelp.modelo.Service.IBalonService;

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
public class BalonRestController {
    @Autowired
    private IBalonService balonService;

    @GetMapping("/balon")
    public List<Balon> Listar(){
        return balonService.findAll();
    }

    @GetMapping("/balon/{id}")
    public Balon mostrar(@PathVariable Long id){
        return balonService.findById(id);
    }

    @PostMapping("/balon")
    @ResponseStatus(HttpStatus.CREATED)
    public Balon crear(@RequestBody Balon balon){
        return balonService.save(balon);
    }

    @PutMapping("/balon/{id}")
    public Balon actualizar(@RequestBody Balon balon, @PathVariable Long id){
        Balon balonOriginal = balonService.findById(id);
        // set and get for the original 
        balonOriginal.setCapacidad(balon.getCapacidad());
        balonOriginal.setPerteneceAdministrador(balon.getPerteneceAdministrador());
        balonOriginal.setPerteneceRegistro(balon.getPerteneceRegistro());
        balonOriginal.setTieneEstado(balon.getTieneEstado());
        return balonService.save(balonOriginal);
    }

    @DeleteMapping("/balon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        balonService.delete(id);
    }
}
