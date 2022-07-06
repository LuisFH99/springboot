package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Cliente;


import java.util.List;

public interface IClienteService {

    List<Cliente> listarCliente();
    Cliente registrarCliente(Cliente body);
    Cliente actualizar(Cliente body, Long idCliente);
    String eliminar(Long idCliente);
}
