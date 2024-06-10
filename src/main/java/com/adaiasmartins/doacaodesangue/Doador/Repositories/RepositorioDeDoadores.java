package com.adaiasmartins.doacaodesangue.Doador.Repositories;

import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeDoadores extends JpaRepository<Doador, Long>{

    Doador findByEmail(String email);
    Doador findByCpf(String cpf);
}
