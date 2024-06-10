package com.adaiasmartins.doacaodesangue.Doacao.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CriarDoacaoDTO(
        @NotBlank @Size(min = 11, max = 11)
        String cpfDoador,
        @NotBlank @FutureOrPresent
        Date data,
        @NotBlank @Size(min = 1, max = 3)
        String tipoSanguineo,
        @NotBlank
        String quantidadeDoada,
        @NotBlank
        String local
) {
}
