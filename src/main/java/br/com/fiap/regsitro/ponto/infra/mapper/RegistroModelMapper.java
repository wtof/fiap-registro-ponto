package br.com.fiap.regsitro.ponto.infra.mapper;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UsuarioModelMapper.class)
public interface RegistroModelMapper {
    Registro toDomain(RegistroModel registroModel);
    RegistroModel toModel(Registro registro);
}