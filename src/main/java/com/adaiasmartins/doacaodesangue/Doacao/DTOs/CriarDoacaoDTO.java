package com.adaiasmartins.doacaodesangue.Doacao.DTOs;

import java.util.Date;

public record CriarDoacaoDTO(
        String cpfDoador,
        Date data,
        String tipoSanguineo,
        String quantidadeDoada,
        String local
) {
}
