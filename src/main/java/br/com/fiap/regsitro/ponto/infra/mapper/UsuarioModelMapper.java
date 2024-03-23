package br.com.fiap.regsitro.ponto.infra.mapper;

import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.infra.model.UsuarioModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioModelMapper {

    Usuario toDomain(UsuarioModel usuarioModel);

    UsuarioModel toModel(Usuario usuario);
}