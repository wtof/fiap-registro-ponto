package br.com.fiap.regsitro.ponto.domain.service;

import br.com.fiap.regsitro.ponto.domain.entity.Usuario;

public interface UsuarioService {
    Usuario buscarUsuarioPorEmail(String email);
}
