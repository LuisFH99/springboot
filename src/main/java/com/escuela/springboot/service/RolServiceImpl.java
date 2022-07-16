package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empleado;
import com.escuela.springboot.Dto.Rol;
import com.escuela.springboot.repository.EmpleadoRepository;
import com.escuela.springboot.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements IRolService{
    @Autowired
    RolRepository rolRepository;

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol registrarRol(Rol body) {
        Rol rolRegistrar=new Rol(null, body.getNombre(), null);
        return rolRepository.save(rolRegistrar);
    }

    @Override
    public Rol actualizarRol(Rol body, Long idRol) {
        //List<Empleado> encontradoEmpleado=empleadoRepository.findAllById(body.getEmpleados().stream().map(Empleado::getId).collect(Collectors.toList()));
        Optional<Rol> encontrado = rolRepository.findById(idRol);
        if (encontrado.isPresent()){
            Rol rolActualizado=encontrado.get();
            rolActualizado.setId(idRol);
            rolActualizado.setNombre(body.getNombre());
            //rolActualizado.setEmpleados(encontradoEmpleado);
            return rolRepository.save(rolActualizado);
        }
        return null;
    }

    @Override
    public String eliminarRol(Long idRol) {
        Optional<Rol> encontrado=rolRepository.findById(idRol);
        if (encontrado.isPresent()){
            rolRepository.deleteById(idRol);
            return "El rol fue eliminado de forma correcta";
        }
        return "El rol no se encuentra registrado";
    }
}
