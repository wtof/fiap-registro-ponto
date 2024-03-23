package br.com.fiap.regsitro.ponto.infra.ports.controller;

import br.com.fiap.regsitro.ponto.domain.ports.usecases.RegistroUseCase;
import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class RegistroController {
    final RegistroUseCase registroUseCase;

    public RegistroController(RegistroUseCase registroUseCase) {
        this.registroUseCase = registroUseCase;
    }
    @PostMapping("/registro")
    public ResponseEntity<String> registrarPonto() {
        registroUseCase.registarMarcacao();
        return ResponseEntity.ok("Registro efetuado com sucesso!!");
    }

    @GetMapping("/registro")
    public ResponseEntity<String> gerarRelatorio(@RequestParam Long usuarioId) {
        // Implementar a lógica para gerar o relatório aqui
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/registros")
    public ResponseEntity<List<RegistroModel>> visualizarRegistros(@RequestParam Long usuarioId) {
        // Implementar a lógica para visualizar os registros aqui
        List<RegistroModel> registros = Collections.emptyList();
        return ResponseEntity.ok(registros);
    }
}