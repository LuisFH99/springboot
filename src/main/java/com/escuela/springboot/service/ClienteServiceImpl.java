package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Cliente;
import com.escuela.springboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//los Servicios son los que contienen la logia de negocio
@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente registrarCliente(Cliente body) {
        Cliente clienteRegistrado=new Cliente(body.getId(), body.getNombres(), body.getSexo(), body.getTelefono());
        clienteRepository.save(clienteRegistrado);
        return clienteRegistrado;
    }

    @Override
    public Cliente actualizar(Cliente body, Long idCliente) {

        Optional<Cliente> encotrado=  clienteRepository.findById(idCliente);
        if (encotrado.isPresent()){
            Cliente clienteActualizado=encotrado.get();
            clienteActualizado.setNombres(body.getNombres());
            clienteActualizado.setSexo(body.getSexo());
            clienteActualizado.setTelefono(body.getTelefono());
            return clienteRepository.save(clienteActualizado);

        }
        return null;
    }

    @Override
    public String eliminar(Long idCliente) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(idCliente);
        if (clienteEncontrado.isPresent()){
            clienteRepository.deleteById(idCliente);
            return "Cliente Eliminado Correctamente";
        }
        return "El cliente no esta Registrado";
    }
}
