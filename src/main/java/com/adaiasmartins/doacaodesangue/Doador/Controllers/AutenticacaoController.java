package com.adaiasmartins.doacaodesangue.Doador.Controllers;

import com.adaiasmartins.doacaodesangue.Doador.DTOs.AutenticacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Services.DoadorServices;
import com.adaiasmartins.doacaodesangue.Doador.Services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private DoadorServices service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AutenticacaoDTO autenticacaoDTO) throws Exception {
        var token = new UsernamePasswordAuthenticationToken(autenticacaoDTO.cpf(), autenticacaoDTO.senha());
        var autenticacao = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Doador) autenticacao.getPrincipal()));
    }
}
