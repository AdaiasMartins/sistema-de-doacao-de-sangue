package com.adaiasmartins.doacaodesangue.Doacao.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CriarDoacaoDTO(
        @NotBlank @Size(min = 11, max = 11)
        String cpfDoador,
        @NotNull @FutureOrPresent
        Date data,
        @NotBlank
        String quantidadeDoada,
        @NotBlank
        String local
) {
}
