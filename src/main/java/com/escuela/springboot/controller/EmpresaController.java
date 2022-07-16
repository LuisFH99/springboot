package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Empresa;
import com.escuela.springboot.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    IEmpresaService iEmpresaService;

    @GetMapping("/listar")
    public List<Empresa> listarEmpresas(){
        return iEmpresaService.listarEmpresas();
    }

    @PostMapping("/registrar")
    public Empresa registrarEmpresa(@RequestBody Empresa body){
        return iEmpresaService.registrarEmpresa(body);
    }

    @PutMapping("/actualizar/{id}")
    public Empresa actualizarEmpresa(@RequestBody Empresa body,@PathVariable("id") Long idEmpresa){
        return iEmpresaService.actualizarEmpresa(body,idEmpresa);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarEmpresa(@PathVariable("id") Long idEmpresa){
        return iEmpresaService.eliminarEmpresa(idEmpresa);
    }
}
