package com.adaiasmartins.doacaodesangue.Doador.DTOs;

import jakarta.validation.constraints.NotBlank;

public record AtualizarDoadorDTO(
        @NotBlank
        String cpf,
        String email,
        String senha,
        String telefone,
        String endereco,
        String cidade,
        String estado
) {
}
