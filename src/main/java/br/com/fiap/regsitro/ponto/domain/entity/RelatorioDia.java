package br.com.fiap.regsitro.ponto.domain.entity;

import java.util.List;

public class RelatorioDia {
    List<Registro> registros;
    Long totalHorasTrabalhada;

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public Long getTotalHorasTrabalhada() {
        return totalHorasTrabalhada;
    }

    public void setTotalHorasTrabalhada(Long totalHorasTrabalhada) {
        this.totalHorasTrabalhada = totalHorasTrabalhada;
    }
}
