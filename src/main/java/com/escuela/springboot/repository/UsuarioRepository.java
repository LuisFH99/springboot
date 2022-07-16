package com.escuela.springboot.repository;

import com.escuela.springboot.Dto.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
