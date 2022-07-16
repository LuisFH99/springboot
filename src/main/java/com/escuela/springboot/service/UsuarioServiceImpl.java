package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Empleado;
import com.escuela.springboot.Dto.Usuario;
import com.escuela.springboot.repository.EmpleadoRepository;
import com.escuela.springboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario registrarUsuario(Usuario body) {
        Optional<Empleado> empleadoEncontrado=empleadoRepository.findById(body.getEmpleado().getId());
        if(empleadoEncontrado.isPresent()){
            Usuario usuarioRegistrar=new Usuario(null, body.getUsername(), body.getPassword(), empleadoEncontrado.get());
            return usuarioRepository.save(usuarioRegistrar);
        }
        return null;
    }

    @Override
    public Usuario actualizarUsuario(Usuario body, Long idUsuario) {
        Optional<Empleado> empleadoEncontrado=empleadoRepository.findById(body.getEmpleado().getId());
        Optional<Usuario> usuarioEncontrado=usuarioRepository.findById(idUsuario);
        if (empleadoEncontrado.isPresent() && usuarioEncontrado.isPresent()){
            Usuario usuarioActualizado = usuarioEncontrado.get();
            usuarioActualizado.setId(idUsuario);
            usuarioActualizado.setUsername(body.getUsername());
            usuarioActualizado.setPassword(body.getPassword());
            usuarioActualizado.setEmpleado(empleadoEncontrado.get());
            return usuarioRepository.save(usuarioActualizado);
        }
        return null;
    }

    @Override
    public String eliminarUsuario(Long idUsuario) {
        Optional<Usuario> usuarioEncontrado=usuarioRepository.findById(idUsuario);
        if (usuarioEncontrado.isPresent()){
            usuarioRepository.deleteById(idUsuario);
            return "El usuario se elimino de forma correcta";
        }
        return "El usuario no se encuentra registrado";
    }
}
