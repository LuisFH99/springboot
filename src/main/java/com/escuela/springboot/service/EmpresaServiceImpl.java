package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empresa;
import com.escuela.springboot.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa registrarEmpresa(Empresa body) {
        Empresa empresa=new Empresa(null, body.getRazonSocial(), body.getRuc(), body.getRepresentante(), new Date());
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa actualizarEmpresa(Empresa body, Long idEmpresa) {
        Optional<Empresa> empresaEncontrado = empresaRepository.findById(idEmpresa);
        if (empresaEncontrado.isPresent()){
            Empresa empresaActualizado=empresaEncontrado.get();
            empresaActualizado.setId(idEmpresa);
            empresaActualizado.setRazonSocial(body.getRazonSocial());
            empresaActualizado.setRepresentante(body.getRepresentante());
            empresaActualizado.setFechaCreacion(new Date());
            return empresaRepository.save(empresaActualizado);
        }
        return null;
    }

    @Override
    public String eliminarEmpresa(Long idEmpresa) {
        Optional<Empresa> empresaEncontrado=empresaRepository.findById(idEmpresa);
        if (empresaEncontrado.isPresent()){
            empresaRepository.deleteById(idEmpresa);
            return "La empresa se elimino de forma correcta";
        }
        return "La empresa no se encuentra registrado";
    }
}
