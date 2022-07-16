package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Usuario;
import com.escuela.springboot.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService iUsuarioService;

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios(){
        return iUsuarioService.listarUsuarios();
    }

    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario body){
        return iUsuarioService.registrarUsuario(body);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario actualizarUsuario(@RequestBody Usuario body,@PathVariable("id") Long idUsuario){
        return iUsuarioService.actualizarUsuario(body, idUsuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long idUsuario){
        return iUsuarioService.eliminarUsuario(idUsuario);
    }
}
