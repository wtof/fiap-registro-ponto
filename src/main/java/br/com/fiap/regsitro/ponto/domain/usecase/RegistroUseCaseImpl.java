package br.com.fiap.regsitro.ponto.domain.usecase;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.domain.ports.usecases.RegistroUseCase;
import br.com.fiap.regsitro.ponto.domain.service.RegistroService;
import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RegistroUseCaseImpl implements RegistroUseCase {

    private final RegistroService service;

    public RegistroUseCaseImpl(RegistroService registroService) {
        this.service = registroService;
    }

    @Override
    public void registarMarcacao() {

        Registro registro = new Registro();
        registro.setDataRegistro(LocalDateTime.now());
        registro.setTipoRegistro(TipoRegistro.Entrada);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Walter");
        usuario.setEmail("walteroliveiraflorencio@gmail.com");

        registro.setUsuario(usuario);

        service.salvarRegistro(registro);
    }
}
