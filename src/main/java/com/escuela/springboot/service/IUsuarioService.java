package com.escuela.springboot.service;

import com.escuela.springboot.Dto.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario registrarUsuario(Usuario body);
    Usuario actualizarUsuario(Usuario body,Long idUsuario);
    String eliminarUsuario(Long idUsuario);
}
