package com.escuela.springboot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nombres;
    private String sexo;
    private String telefono;
}
