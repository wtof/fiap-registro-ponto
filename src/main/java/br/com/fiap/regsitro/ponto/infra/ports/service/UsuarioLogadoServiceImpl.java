package br.com.fiap.regsitro.ponto.infra.ports.service;

import br.com.fiap.regsitro.ponto.domain.service.UsuarioLogadoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    public String getEmailUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof OidcUser) {
            OidcUser authenticatedUser = (OidcUser) authentication.getPrincipal();
            Map<String, Object> claims = authenticatedUser.getClaims();
            Object preferredUsername = claims.get("preferred_username");
            return preferredUsername.toString();
        }
        throw new IllegalStateException("User not authenticated");
    }
}
