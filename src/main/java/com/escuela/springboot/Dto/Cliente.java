package com.escuela.springboot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres",length = 120)
    private String nombres;

    @Column(name = "sexo",length = 1)
    private String sexo;
    @Transient
    private String telefono;

    public Cliente(Long id,String nombres){
        this.id=id;
        this.nombres=nombres;
    }
}
