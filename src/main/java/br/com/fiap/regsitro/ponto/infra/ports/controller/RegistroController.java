package br.com.fiap.regsitro.ponto.infra.ports.controller;

import br.com.fiap.regsitro.ponto.application.mapper.RegistroPayloadMapper;
import br.com.fiap.regsitro.ponto.application.payload.RegistroResponse;
import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.RelatorioDia;
import br.com.fiap.regsitro.ponto.domain.ports.usecases.RegistroUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class RegistroController {
    final RegistroUseCase registroUseCase;
    final RegistroPayloadMapper registroPayloadMapper;

    public RegistroController(RegistroUseCase registroUseCase, RegistroPayloadMapper registroPayloadMapper) {
        this.registroUseCase = registroUseCase;
        this.registroPayloadMapper = registroPayloadMapper;
    }
    @PostMapping("/registro")
    public ResponseEntity<String> registrarPonto() {
        registroUseCase.registarMarcacao();
        return ResponseEntity.ok("Registro efetuado com sucesso!!");
    }

    @GetMapping("/relatorio")
    public ResponseEntity<String> gerarRelatorio() {
        registroUseCase.enviarRegistrosPorEmail();
        return ResponseEntity.ok("Relatório enviado por e-mail com sucesso !");
    }

    @GetMapping("/registros")
    public ResponseEntity<RelatorioDia> visualizarRegistros() {
        return ResponseEntity.ok(registroUseCase.buscarRelatorioDoUsuarioDoDia());
    }
}