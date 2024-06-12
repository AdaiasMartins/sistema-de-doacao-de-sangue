package com.adaiasmartins.doacaodesangue.Doador.Controllers;

import com.adaiasmartins.doacaodesangue.Doador.DTOs.AutenticacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.TokenDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Services.AutenticacaoService;
import com.adaiasmartins.doacaodesangue.Doador.Services.DoadorServices;
import com.adaiasmartins.doacaodesangue.Doador.Services.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private AutenticacaoService service;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody @Valid CadastrarDoadorDTO data){
        try {
            return ResponseEntity.ok(service.cadastrarDoador(data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    @Transactional
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AutenticacaoDTO data) throws Exception {
        var token = new UsernamePasswordAuthenticationToken(data.cpf(), data.senha());
        var autenticacao = manager.authenticate(token);
        var TokenJWT = tokenService.gerarToken((Doador) autenticacao.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(TokenJWT));
    }
}
