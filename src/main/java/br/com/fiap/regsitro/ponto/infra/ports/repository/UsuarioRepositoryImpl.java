package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.domain.ports.repository.UsuarioRepository;
import br.com.fiap.regsitro.ponto.infra.mapper.UsuarioModelMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioJPARepository repository;
    private final UsuarioModelMapper mapper;

    public UsuarioRepositoryImpl(UsuarioJPARepository repository, UsuarioModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
         return mapper.toDomain(repository.findByEmail(email));
    }
}
