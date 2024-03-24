package br.com.fiap.regsitro.ponto.domain.ports.usecases;

import br.com.fiap.regsitro.ponto.domain.entity.RelatorioDia;

public interface RegistroUseCase {
    void registarMarcacao();
    RelatorioDia buscarRelatorioDoUsuarioDoDia();
    void enviarRegistrosPorEmail();
}
