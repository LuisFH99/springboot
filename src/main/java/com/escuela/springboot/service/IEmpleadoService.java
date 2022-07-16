package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empleado;


import java.util.List;

public interface IEmpleadoService {

    List<Empleado> listarEmpleado();
    List<Empleado> filtrarEmpleadosPorNombre(String texto);
    Empleado registrarEmpleado(Empleado body);
    Empleado actualizar(Empleado body, Long idEmpleado);
    String eliminar(Long idEmpleado);
}
