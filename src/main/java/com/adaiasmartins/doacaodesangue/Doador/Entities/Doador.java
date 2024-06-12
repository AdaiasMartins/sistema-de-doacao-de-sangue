package com.adaiasmartins.doacaodesangue.Doador.Entities;

import com.adaiasmartins.doacaodesangue.Doacao.Entities.Doacao;
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
import java.util.Date;
import java.util.List;

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
    private Date dataNascimento;
    private String telefone;
    private String tipoSanguineo;
    private String endereco;
    private String cidade;
    private String estado;
    private boolean ativo = true;
    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doacao> doacoes;

    public Doador(CadastrarDoadorDTO data, String senha){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.senha = senha;
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
