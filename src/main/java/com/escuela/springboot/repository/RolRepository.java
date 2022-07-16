package com.escuela.springboot.repository;

import com.escuela.springboot.Dto.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
