package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empresa;

import java.util.List;

public interface IEmpresaService {

    List<Empresa> listarEmpresas();
    Empresa registrarEmpresa(Empresa body);
    Empresa actualizarEmpresa(Empresa body,Long idEmpresa);
    String eliminarEmpresa(Long idEmpresa);
}
