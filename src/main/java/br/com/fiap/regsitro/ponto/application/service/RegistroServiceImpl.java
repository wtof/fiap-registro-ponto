package br.com.fiap.regsitro.ponto.application.service;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.ports.repository.RegistroRepository;
import br.com.fiap.regsitro.ponto.domain.service.RegistroService;
import br.com.fiap.regsitro.ponto.infra.mapper.RegistroModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {

    final RegistroRepository repository;
    final RegistroModelMapper mapper;

    public RegistroServiceImpl(RegistroRepository repository, RegistroModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void salvarRegistro(Registro registro) {
        repository.salvar(mapper.toModel(registro));
    }
}
