package com.adaiasmartins.doacaodesangue.Doador.Services;


import com.adaiasmartins.doacaodesangue.Doador.DTOs.AtivacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.AtualizarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.BuscarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Exceptions.DoadorNaoEncontradoException;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoadorServices {
    @Autowired
    private RepositorioDeDoadores repositorioDeDoadores;


    public Doador cadastrarDoador(@Valid CadastrarDoadorDTO data) throws Exception {
    try {
        Doador doador = new Doador(data);
        return repositorioDeDoadores.save(doador);
    } catch (Exception e){
        throw new Exception("Erro ao cadastrar doador");
    }
    }

    public Doador buscarDoador(@Valid String cpf) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(cpf);
            if (doador == null) {
                throw new DoadorNaoEncontradoException("O cpf informado não está cadastrado");
            }
            return doador;
        } catch (Exception e){
            throw new Exception("Erro ao buscar doador");
        }
    }


    public Doador atualizarDoador(@Valid AtualizarDoadorDTO data) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(data.cpf());
            if (doador == null) {
                throw new DoadorNaoEncontradoException("Erro ao buscar doador");
            }
            Optional.ofNullable(data.email()).ifPresent(doador::setEmail);
            Optional.ofNullable(data.senha()).ifPresent(doador::setSenha);
            Optional.ofNullable(data.telefone()).ifPresent(doador::setTelefone);
            Optional.ofNullable(data.endereco()).ifPresent(doador::setEndereco);
            Optional.ofNullable(data.cidade()).ifPresent(doador::setCidade);
            Optional.ofNullable(data.estado()).ifPresent(doador::setEstado);
            return repositorioDeDoadores.save(doador);
        } catch (Exception e){
            throw new Exception("Erro ao atualizar doador", e);
        }
    }

    public void InativarDoador(@Valid AtivacaoDTO data) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(data.cpf());
            if (doador == null) {
                throw new DoadorNaoEncontradoException("O cpf informado não está cadastrado");
            }else if (!doador.isAtivo()){
                throw new Exception("Doador já está inativo");
            }
            doador.setAtivo(false);
            repositorioDeDoadores.save(doador);
        } catch (Exception e){
            throw new Exception("Erro ao inativar doador");
        }
    }
}
