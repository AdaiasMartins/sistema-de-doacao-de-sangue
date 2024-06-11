package com.adaiasmartins.doacaodesangue.Doador.Entities;

import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Table(name = "doadores")
@Entity(name = "Doador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doador implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.cpf;
    }
}
