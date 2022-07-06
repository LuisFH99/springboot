package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Cliente;
import com.escuela.springboot.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//especificamos que publique los metodos de esta clase
// --> los controlladores no mucho codigo,
//              solo se encargan de comunicar el proyecto con el cliente
@RestController
public class ClienteController {

    //anotación que nos permite implementar, instancia o inyectar elementos de un bean
    @Autowired
    IClienteService iClienteService;

    @GetMapping("/listar")
    List<Cliente> listarCliente(){
        return iClienteService.listarCliente();
    }

    @PostMapping("/registrar")
    Cliente registrarCliente(@RequestBody Cliente body){
        return iClienteService.registrarCliente(body);
    }

    @PutMapping("/actualizar/{id}")
    Cliente actualizar(@RequestBody Cliente body,@PathVariable("id") Long idCliente){
        return iClienteService.actualizar(body,idCliente);
    }

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long idCliente){
        return iClienteService.eliminar(idCliente);
    }

}
