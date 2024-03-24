package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.Usuario;
import br.com.fiap.regsitro.ponto.domain.ports.repository.RegistroRepository;
import br.com.fiap.regsitro.ponto.infra.mapper.RegistroModelMapper;
import br.com.fiap.regsitro.ponto.infra.mapper.UsuarioModelMapper;
import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistroRepositoryImpl implements RegistroRepository {

    public final RegistroJPARepository repository;
    public final RegistroModelMapper registroMapper;
    public final UsuarioModelMapper usuarioMapper;
    public final EntityManager entityManager;

    public RegistroRepositoryImpl(RegistroJPARepository repository, RegistroModelMapper mapper, UsuarioModelMapper usuarioMapper, EntityManager entityManager) {
        this.repository = repository;
        this.registroMapper = mapper;
        this.usuarioMapper = usuarioMapper;
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Registro registro) {
        repository.save(registroMapper.toModel(registro));
    }

    @Override
    public Registro buscarUltimoRegistroDoUsuario(Usuario usuario) {
        RegistroModel registroModel = repository.findFirstByUsuarioOrderByDataRegistroDesc(usuarioMapper.toModel(usuario));
        return registroMapper.toDomain(registroModel);
    }

    @Override
    public List<Registro> buscarTodosRegistrosDoUsuario(Usuario usuario) {
        return registroMapper.toDomainList(repository.findByUsuario(usuarioMapper.toModel(usuario)));
    }

    @Override
    public List<Registro> buscarTodosRegistrosDoUsuarioMesAnterior(Usuario usuario) {
        return registroMapper.toDomainList(repository.findPreviousMonthRegistroByUser(usuario.getId()));
    }

    @Override
    public List<Registro> buscarTodosRegistrosDoDia(Usuario usuario) {
        return registroMapper.toDomainList(repository.findTodayRegistroByUser(usuario.getId()));
    }
}
