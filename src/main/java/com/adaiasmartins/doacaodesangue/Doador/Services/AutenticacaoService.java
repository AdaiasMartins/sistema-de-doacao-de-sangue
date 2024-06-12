package com.adaiasmartins.doacaodesangue.Doador.Services;

import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Exceptions.DoadorExistenteException;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import jakarta.validation.Valid;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService{

    @Autowired
    private RepositorioDeDoadores repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositorio.findByCpf(username);
    }

    public Doador cadastrarDoador(@Valid CadastrarDoadorDTO data) throws Exception {
        try {
            if(repositorio.findByCpf(data.cpf()) != null){
                throw new DoadorExistenteException("O doador informado já existe");
            }
            String senha = passwordEncoder.encode(data.senha());
            Doador doador = new Doador(data, senha);
            return repositorio.save(doador);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

}
