package com.adaiasmartins.doacaodesangue.Doador.DTOs;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
