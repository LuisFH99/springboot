package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Rol;

import java.util.List;

public interface IRolService {

    List<Rol> listarRoles();

    Rol registrarRol(Rol body);

    Rol actualizarRol(Rol body,Long idRol);

    String eliminarRol(Long idRol);
}
