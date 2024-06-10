package com.adaiasmartins.doacaodesangue.Doador.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AtivacaoDTO(
        @NotBlank @Size(min = 11, max = 11)
        String cpf
) {
}
