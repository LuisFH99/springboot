package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empleado;
import com.escuela.springboot.Dto.Empresa;
import com.escuela.springboot.Dto.Rol;
import com.escuela.springboot.repository.EmpleadoRepository;
import com.escuela.springboot.repository.EmpresaRepository;
import com.escuela.springboot.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//los Servicios son los que contienen la logia de negocio
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Empleado> listarEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> filtrarEmpleadosPorNombre(String texto) {
        return empleadoRepository.findByNombresContaining(texto);
    }

    @Override
    public Empleado registrarEmpleado(Empleado body) {
        Optional<Empresa> empresa=empresaRepository.findById(body.getEmpresa().getId());
        List<Rol> rolList=rolRepository.findAllById(body.getRoles().stream().map(Rol::getId).collect(Collectors.toList()));
        if(empresa.isPresent() && rolList.size() == body.getRoles().size()){
            Empleado EmpleadoRegistrado=new Empleado(null, body.getNombres(), body.getSexo(), body.getTelefono(),empresa.get(),rolList);
            empleadoRepository.save(EmpleadoRegistrado);
            return EmpleadoRegistrado;
        }
        return null;
    }

    @Override
    public Empleado actualizar(Empleado body, Long idEmpleado) {
        Optional<Empresa> empresa = empresaRepository.findById(body.getEmpresa().getId());
        List<Rol> rolList = rolRepository.findAllById(body.getRoles().stream().map(Rol::getId).collect(Collectors.toList()));
        Optional<Empleado> encotrado=  empleadoRepository.findById(idEmpleado);
        if (encotrado.isPresent() && empresa.isPresent() && rolList.size() == body.getRoles().size()){
            Empleado EmpleadoActualizado=encotrado.get();
            EmpleadoActualizado.setNombres(body.getNombres());
            EmpleadoActualizado.setSexo(body.getSexo());
            EmpleadoActualizado.setTelefono(body.getTelefono());
            EmpleadoActualizado.setEmpresa(empresa.get());
            EmpleadoActualizado.setRoles(rolList);
            return empleadoRepository.save(EmpleadoActualizado);
        }
        return null;
    }

    @Override
    public String eliminar(Long idEmpleado) {
        Optional<Empleado> EmpleadoEncontrado = empleadoRepository.findById(idEmpleado);
        if (EmpleadoEncontrado.isPresent()){
            empleadoRepository.deleteById(idEmpleado);
            return "Empleado Eliminado Correctamente";
        }
        return "El Empleado no esta Registrado";
    }
}
