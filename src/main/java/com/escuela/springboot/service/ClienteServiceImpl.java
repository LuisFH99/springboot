package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//los Servicios son los que contienen la logia de negocio
@Service
public class ClienteServiceImpl implements IClienteService{

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> listarCliente() {
        return clientes;
    }

    @Override
    public Cliente registrarCliente(Cliente body) {
        Cliente clienteRegistrado=new Cliente(body.getId(), body.getNombres(), body.getSexo(), body.getTelefono());
        clientes.add(clienteRegistrado);
        return clienteRegistrado;
    }

    @Override
    public Cliente actualizar(Cliente body, Long idCliente) {
        Optional<Cliente> encotrado=  clientes.stream().filter(cliente -> cliente.getId().equals(idCliente)).findFirst();
        if (encotrado.isPresent()){
            Cliente clienteActualizado=encotrado.get();
            clienteActualizado.setNombres(body.getNombres());
            clienteActualizado.setSexo(body.getSexo());
            clienteActualizado.setTelefono(body.getTelefono());
            clientes.forEach(cliente -> {
                if (cliente.getId().equals(idCliente)){
                    cliente = clienteActualizado;
                }
            });
            return clienteActualizado;
        }
        return null;
    }

    @Override
    public String eliminar(Long idCliente) {
        Optional<Cliente> clienteEncontrado = clientes.stream().filter(cliente -> cliente.getId().equals(idCliente)).findFirst();
        if (clienteEncontrado.isPresent()){
            clientes.remove(clienteEncontrado.get());
            return "Cliente Eliminado";
        }
        return "El cliente no esta Registrado";
    }
}
