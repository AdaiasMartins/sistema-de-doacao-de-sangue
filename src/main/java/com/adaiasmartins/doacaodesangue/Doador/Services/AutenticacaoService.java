package com.adaiasmartins.doacaodesangue.Doador.Services;

import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private RepositorioDeDoadores repositorio;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorio.findByCpf(username);
    }
}
