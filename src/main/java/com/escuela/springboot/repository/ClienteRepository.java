package com.escuela.springboot.repository;

import com.escuela.springboot.Dto.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByNombresContaining(String text);

    @Query(value = "select new Cliente(p.id,p.nombres) from Cliente p")
    List<Cliente> listarClienteJPQL();

    @Query(value = "select * from clientes",nativeQuery = true)
    List<Cliente> listarClienteSQL();
}
