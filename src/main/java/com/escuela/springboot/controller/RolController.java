package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Rol;
import com.escuela.springboot.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    IRolService iRolService;

    @GetMapping("/listar")
    public List<Rol> listarRoles(){
        return iRolService.listarRoles();
    }

    @PostMapping("/registrar")
    public Rol registarRol(@RequestBody Rol body){
        return iRolService.registrarRol(body);
    }

    @PutMapping("/actualizar/{id}")
    public Rol actualizarRol(@RequestBody Rol body,@PathVariable("id") Long idRol){
        return iRolService.actualizarRol(body,idRol);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable("id") Long idRol){
        return iRolService.eliminarRol(idRol);
    }
}
