package com.adaiasmartins.doacaodesangue.Doador.DTOs;

import jakarta.validation.constraints.*;

import java.util.Date;

public record CadastrarDoadorDTO(
        @NotBlank
        String nome,
        @NotBlank @Size(min = 11, max = 11)
        String cpf,
        @NotBlank @Email
        String email,
        @NotBlank @Size(min = 6)
        String senha,
        @NotNull @Past
        Date dataNascimento,
        @NotBlank @Size(min = 10, max = 10)
        String telefone,
        @NotBlank @Size(min = 2, max = 3)
        String tipoSanguineo,
        @NotBlank
        String endereco,
        @NotBlank
        String cidade,
        @NotBlank
        String estado) {

}
