package br.com.fiap.regsitro.ponto.domain.ports.repository;

import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;

public interface RegistroRepository {
    void salvar(RegistroModel registro);

}
