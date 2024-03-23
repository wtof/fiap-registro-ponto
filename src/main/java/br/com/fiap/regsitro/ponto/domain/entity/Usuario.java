package br.com.fiap.regsitro.ponto.domain.entity;

import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nome;
    private String email;
}
