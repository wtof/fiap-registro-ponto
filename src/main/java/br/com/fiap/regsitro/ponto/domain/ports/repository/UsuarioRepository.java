package br.com.fiap.regsitro.ponto.domain.ports.repository;

import br.com.fiap.regsitro.ponto.domain.entity.Usuario;

public interface UsuarioRepository {
    public Usuario buscarUsuarioPorEmail(String email);
}
