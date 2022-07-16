package com.escuela.springboot.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres",length = 120)
    private String nombres;

    @Column(name = "sexo",length = 1)
    private String sexo;

    @Transient
    private String telefono;

    @ManyToOne
    private Empresa empresa;

    @ManyToMany
    @JoinTable(name = "EmpleadoRoles", joinColumns = @JoinColumn(name = "empleado_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @JsonIgnoreProperties("empleados")
    private List<Rol> roles;

    public Empleado(Long id, String nombres){
        this.id=id;
        this.nombres=nombres;
    }
}
