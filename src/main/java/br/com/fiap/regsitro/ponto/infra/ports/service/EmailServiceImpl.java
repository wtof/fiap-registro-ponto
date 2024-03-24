package br.com.fiap.regsitro.ponto.infra.ports.service;

import br.com.fiap.regsitro.ponto.application.mapper.RegistroPayloadMapper;
import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.domain.service.EmailService;
import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private final RegistroPayloadMapper mapper;
    private final JavaMailSender emailSender;

    public EmailServiceImpl(RegistroPayloadMapper mapper, JavaMailSender emailSender) {
        this.mapper = mapper;
        this.emailSender = emailSender;
    }

    @Override
    public void enviarRegistrosPorEmail(List<Registro> registroList) {

        Usuario usuario = null;

        if(registroList.isEmpty()){
           return;
        } else {
            usuario = registroList.get(0).getUsuario();
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@fiap.ponto.com");
        message.setTo(usuario.getEmail());
        message.setSubject("Hackathon - Ponto de Registro FIAP");


        StringBuilder sb = new StringBuilder();

        Duration totalDuration = Duration.ZERO;
        LocalDateTime entrada = null;
        sb.append("Usuário: ").append(usuario.getNome()).append("\n");
        sb.append("--------------------\n");

        for (Registro registro : registroList) {
            sb.append("Tipo de Registro: ").append(registro.getTipoRegistro()).append("\n");
            sb.append("Data de Registro: ").append(registro.getDataRegistro()).append("\n");
            sb.append("--------------------\n");

            if (registro.getTipoRegistro() == TipoRegistro.Entrada) {
                entrada = registro.getDataRegistro();
            } else if (registro.getTipoRegistro() == TipoRegistro.Saida && entrada != null) {
                Duration duration = Duration.between(entrada, registro.getDataRegistro());
                totalDuration = totalDuration.plus(duration);
                entrada = null;
            }
        }

        sb.append("Total de horas trabalhadas: ").append(totalDuration.toHours()).append("\n");
        message.setText(sb.toString());
        emailSender.send(message);
    }
}
