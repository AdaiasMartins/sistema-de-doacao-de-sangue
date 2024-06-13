package com.adaiasmartins.doacaodesangue.Doador.Security;

import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import com.adaiasmartins.doacaodesangue.Doador.Services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RepositorioDeDoadores repositorio;
    private final List<String> allowedPaths = Arrays.asList("/auth/login", "/auth/register");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (requiresAuthentication(request.getRequestURI())) {
            String token = this.recuperarTokenJWT(request);
            String login = tokenService.validarToken(token);
            if (!login.isEmpty()) {
                UserDetails user = repositorio.findByCpf(login);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean requiresAuthentication(String path) {
        return allowedPaths.stream().noneMatch(path::startsWith);
    }

    private String recuperarTokenJWT(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            if (!requiresAuthentication(request.getRequestURI())) {
                return "";
            }
            return "";
        }
        return authorizationHeader.substring(7);
    }
}
