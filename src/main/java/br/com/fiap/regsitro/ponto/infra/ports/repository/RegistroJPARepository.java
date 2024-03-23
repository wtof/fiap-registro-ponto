package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroJPARepository extends JpaRepository<RegistroModel, Long> {
    List<RegistroModel> findByTipoRegistro(TipoRegistro tipoRegistro);
}