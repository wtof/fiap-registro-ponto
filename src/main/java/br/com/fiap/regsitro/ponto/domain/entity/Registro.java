package br.com.fiap.regsitro.ponto.domain.entity;

import br.com.fiap.regsitro.ponto.infra.model.TipoRegistro;

import java.time.LocalDateTime;

public class Registro {

    private Long id;
    private Usuario usuario;
    private TipoRegistro tipoRegistro;
    LocalDateTime dataRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
