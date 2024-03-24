package br.com.fiap.regsitro.ponto.domain.usecase;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.RelatorioDia;
import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.domain.ports.repository.RegistroRepository;
import br.com.fiap.regsitro.ponto.domain.ports.repository.UsuarioRepository;
import br.com.fiap.regsitro.ponto.domain.ports.usecases.RegistroUseCase;
import br.com.fiap.regsitro.ponto.domain.service.EmailService;
import br.com.fiap.regsitro.ponto.domain.service.UsuarioLogadoService;
import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class RegistroUseCaseImpl implements RegistroUseCase {
    private final RegistroRepository registroRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmailService registroService;
    private final UsuarioLogadoService usuarioLogadoService;

    public RegistroUseCaseImpl(RegistroRepository registroRepository, UsuarioRepository usuarioRepository, EmailService registroService, UsuarioLogadoService usuarioLogadoService) {
        this.registroRepository = registroRepository;
        this.usuarioRepository = usuarioRepository;
        this.registroService = registroService;
        this.usuarioLogadoService = usuarioLogadoService;
    }

    @Override
    @Transactional
    public void registarMarcacao() {
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail(usuarioLogadoService.getEmailUsuarioLogado());
        Registro ultimoRegistro = registroRepository.buscarUltimoRegistroDoUsuario(usuario);

        Registro registro = new Registro();
        registro.setDataRegistro(LocalDateTime.now());
        registro.setTipoRegistro(ultimoRegistro.getTipoRegistro() == TipoRegistro.Entrada ? TipoRegistro.Saida : TipoRegistro.Entrada);
        registro.setUsuario(usuario);

        registroRepository.salvar(registro);
    }

    public RelatorioDia buscarRelatorioDoUsuarioDoDia(){
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail(usuarioLogadoService.getEmailUsuarioLogado());
        List<Registro> registros = registroRepository.buscarTodosRegistrosDoDia(usuario);
        LocalDateTime entrada = null;
        Duration totalDuration = Duration.ZERO;

        for (Registro registro : registros) {

            if (registro.getTipoRegistro() == TipoRegistro.Entrada) {
                entrada = registro.getDataRegistro();
            } else if (registro.getTipoRegistro() == TipoRegistro.Saida && entrada != null) {
                Duration duration = Duration.between(entrada, registro.getDataRegistro());
                totalDuration = totalDuration.plus(duration);
                entrada = null;
            }
        }

        RelatorioDia relatorioDia = new RelatorioDia();
        relatorioDia.setRegistros(registros);
        relatorioDia.setTotalHorasTrabalhada(totalDuration.toHours());

        return relatorioDia;
    }

    @Override
    public void enviarRegistrosPorEmail() {
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail("walteroliveiraflorencio@gmail.com");
        List<Registro> registros = registroRepository.buscarTodosRegistrosDoUsuarioMesAnterior(usuario);
        registroService.enviarRegistrosPorEmail(registros);
    }
}
