package br.com.fiap.regsitro.ponto.application.payload;

import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistroRequest {

    private Long id;

    private Usuario usuario;

    private TipoRegistro tipoRegistro;

    LocalDateTime dataRegistro;
}
