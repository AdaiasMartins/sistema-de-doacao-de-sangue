package com.adaiasmartins.doacaodesangue.Doador.Entities;

import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "doadores")
@Entity(name = "Doador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doador {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String dataNascimento;
    private String telefone;
    private String tipoSanguineo;
    private String endereco;
    private String cidade;
    private String estado;
    private boolean ativo = true;

    public Doador(CadastrarDoadorDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.senha = data.senha();
        this.dataNascimento = data.dataNascimento();
        this.telefone = data.telefone();
        this.tipoSanguineo = data.tipoSanguineo();
        this.endereco = data.endereco();
        this.cidade = data.cidade();
        this.estado = data.estado();
    }
}
