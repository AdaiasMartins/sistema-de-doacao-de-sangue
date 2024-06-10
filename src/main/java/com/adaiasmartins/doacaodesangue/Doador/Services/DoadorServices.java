package com.adaiasmartins.doacaodesangue.Doador.Services;

<<<<<<< HEAD
import com.adaiasmartins.doacaodesangue.Doador.DTOs.AtivacaoDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.AtualizarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.DTOs.BuscarDoadorDTO;
=======
import com.adaiasmartins.doacaodesangue.Doador.DTOs.AtualizarDoadorDTO;
>>>>>>> origin/master
import com.adaiasmartins.doacaodesangue.Doador.DTOs.CadastrarDoadorDTO;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Exceptions.DoadorNaoEncontradoException;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
<<<<<<< HEAD
import jakarta.validation.Valid;
=======
>>>>>>> origin/master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoadorServices {
    @Autowired
    private RepositorioDeDoadores repositorioDeDoadores;

<<<<<<< HEAD
    public Doador cadastrarDoador(@Valid CadastrarDoadorDTO data) throws Exception {
=======
    public Doador cadastrarDoador(CadastrarDoadorDTO data) throws Exception {
>>>>>>> origin/master
    try {
        Doador doador = new Doador(data);
        return repositorioDeDoadores.save(doador);
    } catch (Exception e){
        throw new Exception("Erro ao cadastrar doador");
    }
    }

<<<<<<< HEAD
    public Doador buscarDoador(@Valid BuscarDoadorDTO data) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(data.cpf());
=======
    public Doador buscarDoador(String cpf) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(cpf);
>>>>>>> origin/master
            if (doador == null) {
                throw new DoadorNaoEncontradoException("O cpf informado não está cadastrado");
            }
            return doador;
        } catch (Exception e){
            throw new Exception("Erro ao buscar doador");
        }
    }

<<<<<<< HEAD
    public Doador atualizarDoador(@Valid AtualizarDoadorDTO data) throws Exception {
=======
    public Doador atualizarDoador(AtualizarDoadorDTO data) throws Exception {
>>>>>>> origin/master
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

<<<<<<< HEAD
    public void InativarDoador(@Valid AtivacaoDTO data) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(data.cpf());
            if (doador == null) {
                throw new DoadorNaoEncontradoException("O cpf informado não está cadastrado");
=======
    public void InativarDoador(String cpf) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(cpf);
            if (doador == null) {
                throw new DoadorNaoEncontradoException(cpf);
>>>>>>> origin/master
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
