package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController //especificamos que publique los metodos de esta clase
public class ClienteController {
    private List<Cliente> clientes=new ArrayList<>();

    @GetMapping("/listar")
    List<Cliente> listarCliente(){
        return clientes;
    }

    @PostMapping("/registrar")
    Cliente registrarCliente(@RequestBody Cliente body){
        Cliente clienteRegistrado=new Cliente(body.getId(), body.getNombres(), body.getSexo(), body.getTelefono());
        clientes.add(clienteRegistrado);
        return clienteRegistrado;
    }

    @PutMapping("/actualizar/{id}")
    Cliente actualizar(@RequestBody Cliente body,@PathVariable("id") Long idCliente){
        Optional<Cliente> encotrado=  clientes.stream().filter(cliente -> cliente.getId().equals(idCliente)).findFirst();
        if (encotrado.isPresent()){
            Cliente clienteActualizado=encotrado.get();
            clienteActualizado.setNombres(body.getNombres());
            clienteActualizado.setSexo(body.getSexo());
            clienteActualizado.setTelefono(body.getTelefono());
            clientes.forEach(cliente -> {
                if (cliente.getId().equals(idCliente)){
                    cliente = clienteActualizado;
                }
            });
            return clienteActualizado;
        }
        return null;
    }

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long idCliente){
        Optional<Cliente> clienteEncontrado = clientes.stream().filter(cliente -> cliente.getId().equals(idCliente)).findFirst();
        if (clienteEncontrado.isPresent()){
            clientes.remove(clienteEncontrado.get());
            return "Cliente Eliminado";
        }
        return "El cliente no esta Registrado";
    }

}
