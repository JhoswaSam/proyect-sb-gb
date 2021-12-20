package com.oxihelp.oxihelp.control;

import java.util.List;

import com.oxihelp.oxihelp.modelo.Cliente;
import com.oxihelp.oxihelp.modelo.Service.IClienteService;

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
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/cliente")
    public List<Cliente> Listar(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente mostrar(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteOriginal = clienteService.findById(id);
        // set and get for the original 
        clienteOriginal.setNombre(cliente.getNombre());
        clienteOriginal.setApellidos(cliente.getApellidos());
        clienteOriginal.setDNI(cliente.getDNI());
        clienteOriginal.setDomicilio(cliente.getDomicilio());
        clienteOriginal.setCelular(cliente.getCelular());
        clienteOriginal.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteOriginal.setRegistros(cliente.getRegistros());
        return clienteService.save(clienteOriginal);
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        clienteService.delete(id);
    }

    @GetMapping("/cliente/get/{dni}")
    public Cliente getCliente(@PathVariable String dni){
        Cliente cliente = clienteService.findByDNI(dni);
        if(cliente == null){ return null;}
        return cliente;
    }
}
