package com.escuela.springboot.repository;

import com.escuela.springboot.Dto.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
}
