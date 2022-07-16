package com.escuela.springboot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social", length = 120)
    private String razonSocial;

    @Column(name = "ruc", length = 20)
    private String ruc;

    @Column(name = "representante")
    private String representante;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

//    relacion bidireccional (1 empresa tiene muchos empleados y muchos empleados tiene una empresa)
//    al se muchos empleados se representa con una lista.

//    @OneToMany
//    private List<Empleado> empleados;
}
