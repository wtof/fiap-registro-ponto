package br.com.fiap.regsitro.ponto.domain.ports.repository;

import br.com.fiap.regsitro.ponto.domain.entity.Registro;
import br.com.fiap.regsitro.ponto.domain.entity.Usuario;

import java.util.List;

public interface RegistroRepository {
    void salvar(Registro registro);
    Registro buscarUltimoRegistroDoUsuario(Usuario usuario);
    List<Registro> buscarTodosRegistrosDoUsuario(Usuario usuario);
    List<Registro> buscarTodosRegistrosDoUsuarioMesAnterior(Usuario usuario);
    List<Registro> buscarTodosRegistrosDoDia(Usuario usuario);
}
