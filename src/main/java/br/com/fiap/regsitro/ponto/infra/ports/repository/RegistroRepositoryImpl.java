package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.domain.ports.repository.RegistroRepository;
import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import org.springframework.stereotype.Repository;

@Repository
public class RegistroRepositoryImpl implements RegistroRepository {

    public final RegistroJPARepository repository;

    public RegistroRepositoryImpl(RegistroJPARepository repository) {
        this.repository = repository;

    }

    @Override
    public void salvar(RegistroModel registro) {
        repository.save(registro);
    }
}
