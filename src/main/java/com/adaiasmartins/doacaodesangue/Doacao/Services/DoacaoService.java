package com.adaiasmartins.doacaodesangue.Doacao.Services;

import com.adaiasmartins.doacaodesangue.Doacao.DTOs.CriarDoacaoDTO;
import com.adaiasmartins.doacaodesangue.Doacao.Entities.Doacao;
import com.adaiasmartins.doacaodesangue.Doacao.Exceptions.DoacaoNaoEncontradaException;
import com.adaiasmartins.doacaodesangue.Doacao.Repositories.RepositorioDeDoacoes;
import com.adaiasmartins.doacaodesangue.Doador.Entities.Doador;
import com.adaiasmartins.doacaodesangue.Doador.Exceptions.DoadorNaoEncontradoException;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoacaoService {
    @Autowired
    private RepositorioDeDoadores repositorioDeDoadores;
    @Autowired
    private RepositorioDeDoacoes repositorioDeDoacoes;

    public Doacao criarDoacao(CriarDoacaoDTO data) throws Exception {
        try{
            Doador doador = repositorioDeDoadores.findByCpf(data.cpfDoador());
            if (doador == null) {
                throw new DoadorNaoEncontradoException("O cpf informado não está cadastrado");
            }
            Doacao doacao = new Doacao(doador, data);
            doador.getDoacoes().add(doacao);
            return repositorioDeDoacoes.save(doacao);
        } catch (Exception e){
            throw new Exception("Erro ao criar doação");
        }
    }

    public Doacao buscarDoacao(Long id) throws Exception {
        try {
            Optional<Doacao> doacao = repositorioDeDoacoes.findById(id);
            if(repositorioDeDoacoes.findById(id) == null){
                throw new DoacaoNaoEncontradaException("Doação não encontrada");
            }

            return doacao.get();
        } catch (Exception e) {
            throw new Exception("Erro ao buscar doação");
        }
    }

    public void deletarDoacao(Long id) throws Exception {
        try {
            if (repositorioDeDoacoes.findById(id) == null) {
                throw new DoacaoNaoEncontradaException("Doação não encontrada");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao deletar doação");
        }
    }
}
