package com.adaiasmartins.doacaodesangue.Doacao.Entities;

import com.adaiasmartins.doacaodesangue.Doacao.DTOs.CriarDoacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name = "doador_id")
    @JsonBackReference
    private Doador doador;
    private Date data;
    private String tipoSanguineo;
    private String quantidadeDoada;
    private String local;

    public Doacao(Doador doador, CriarDoacaoDTO data) {
        this.doador = doador;
        this.data = data.data();
        this.tipoSanguineo = doador.getTipoSanguineo();
        this.quantidadeDoada = data.quantidadeDoada();
        this.local = data.local();
    }
}
