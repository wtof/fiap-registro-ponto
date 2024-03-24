package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.infra.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJPARepository extends JpaRepository<UsuarioModel, Long> {
    UsuarioModel findByEmail(String email);
}
