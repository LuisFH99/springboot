package com.escuela.springboot.controller;

import com.escuela.springboot.Dto.Empleado;
import com.escuela.springboot.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//especificamos que publique los metodos de esta clase
// --> los controlladores no mucho codigo,
//              solo se encargan de comunicar el proyecto con el Empleado
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    //anotación que nos permite implementar, instancia o inyectar elementos de un bean
    @Autowired
    IEmpleadoService iEmpleadoService;

    @GetMapping("/listar")
    List<Empleado> listarEmpleado(){
        return iEmpleadoService.listarEmpleado();
    }
    @GetMapping("/filtrar/nombre")
    List<Empleado> filtrarEmpleadosPorNombre(@RequestParam("texto") String texto){
        return iEmpleadoService.filtrarEmpleadosPorNombre(texto);
    }
    @PostMapping("/registrar")
    Empleado registrarEmpleado(@RequestBody Empleado body){
        return iEmpleadoService.registrarEmpleado(body);
    }

    @PutMapping("/actualizar/{id}")
    Empleado actualizar(@RequestBody Empleado body, @PathVariable("id") Long idEmpleado){
        return iEmpleadoService.actualizar(body,idEmpleado);
    }

    @DeleteMapping("/eliminar/{id}")
    String eliminar(@PathVariable("id") Long idEmpleado){
        return iEmpleadoService.eliminar(idEmpleado);
    }

}
