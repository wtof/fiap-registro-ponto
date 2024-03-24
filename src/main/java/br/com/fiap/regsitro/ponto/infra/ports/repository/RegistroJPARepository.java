package br.com.fiap.regsitro.ponto.infra.ports.repository;

import br.com.fiap.regsitro.ponto.infra.model.RegistroModel;
import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;
import br.com.fiap.regsitro.ponto.infra.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegistroJPARepository extends JpaRepository<RegistroModel, Long> {
    List<RegistroModel> findByTipoRegistro(TipoRegistro tipoRegistro);
    RegistroModel findFirstByUsuarioOrderByDataRegistroDesc(@Param("usuario") UsuarioModel usuario);
    List<RegistroModel> findByUsuario(UsuarioModel usuario);
    @Query(value = "SELECT * FROM Registro r WHERE r.usuario_id = :usuario AND MONTH(r.data_registro) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AND YEAR(r.data_registro) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)", nativeQuery = true)
    List<RegistroModel> findPreviousMonthRegistroByUser(@Param("usuario") Long usuario);

    @Query(value = "SELECT * FROM Registro r WHERE r.usuario_id = :usuario AND DATE(r.data_registro) = CURRENT_DATE", nativeQuery = true)
    List<RegistroModel> findTodayRegistroByUser(@Param("usuario") Long usuario);
}