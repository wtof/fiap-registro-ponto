package br.com.fiap.regsitro.ponto.application.mapper;

import br.com.fiap.regsitro.ponto.application.payload.RegistroResponse;
import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistroPayloadMapper {
    Registro toDomain(RegistroResponse registroResponse);
    RegistroResponse toResponse(Registro registro);
    List<RegistroResponse> toResponse(List<Registro> registro);
}
