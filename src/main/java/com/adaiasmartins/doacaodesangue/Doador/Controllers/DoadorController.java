package com.adaiasmartins.doacaodesangue.Doador.Controllers;

import com.adaiasmartins.doacaodesangue.Doacao.DTOs.CriarDoacaoDTO;
import com.adaiasmartins.doacaodesangue.Doacao.Entities.Doacao;
import com.adaiasmartins.doacaodesangue.Doador.Services.DoadorServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DoadorController {
    @Autowired
    private DoadorServices services;

    @PostMapping("/doar")
    @Transactional
    public ResponseEntity<?> doar(@RequestBody @Valid CriarDoacaoDTO data) throws Exception {
        try {
            return ResponseEntity.ok(services.criarDoacao(data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
