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

    @Autowired
    private RepositorioDeDoadores repositorioDeDoadores;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Doador doador;
    private Date data;
    private String tipoSanguineo;
    private String quantidadeDoada;
    private String local;

    public Doacao(CriarDoacaoDTO data){
        this.doador = repositorioDeDoadores.findByCpf(data.cpfDoador());
        this.data = data.data();
        this.tipoSanguineo = data.tipoSanguineo();
        this.quantidadeDoada = data.quantidadeDoada();
        this.local = data.local();
    }
}
