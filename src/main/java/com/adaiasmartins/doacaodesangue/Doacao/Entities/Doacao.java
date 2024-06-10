package com.adaiasmartins.doacaodesangue.Doacao.Entities;

import com.adaiasmartins.doacaodesangue.Doacao.DTOs.CriarDoacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Table(name = "doacoes")
@Entity(name = "Doacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Doador doador;
    private Date data;
    private String tipoSanguineo;
    private String quantidadeDoada;
    private String local;

    public Doacao(Doador doador, Date data, String tipoSanguineo, String quantidadeDoada, String local) {
        this.doador = doador;
        this.data = data;
        this.tipoSanguineo = tipoSanguineo;
        this.quantidadeDoada = quantidadeDoada;
        this.local = local;
    }
}
