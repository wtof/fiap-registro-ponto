package br.com.fiap.regsitro.ponto.domain.service;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;

import java.util.List;

public interface EmailService {
    void enviarRegistrosPorEmail(List<Registro> registroList);
}
