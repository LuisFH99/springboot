package com.escuela.springboot.repository;

import com.escuela.springboot.Dto.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    List<Empleado> findByNombresContaining(String text);

    @Query(value = "select new Empleado(p.id,p.nombres) from Empleado p")
    List<Empleado> listarEmpleadoJPQL();

    @Query(value = "select * from Empleados",nativeQuery = true)
    List<Empleado> listarEmpleadoSQL();
}
