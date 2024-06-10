package com.adaiasmartins.doacaodesangue.Doacao.Repositories;

import com.adaiasmartins.doacaodesangue.Doacao.Entities.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDeDoacoes extends JpaRepository<Doacao, Long> {

        Doacao findByID(Long id);
}
