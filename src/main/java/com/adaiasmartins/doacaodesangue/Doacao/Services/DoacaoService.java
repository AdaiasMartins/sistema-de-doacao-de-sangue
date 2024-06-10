package com.adaiasmartins.doacaodesangue.Doacao.Services;

import com.adaiasmartins.doacaodesangue.Doacao.DTOs.CriarDoacaoDTO;
import com.adaiasmartins.doacaodesangue.Doacao.Entities.Doacao;
import com.adaiasmartins.doacaodesangue.Doacao.Exceptions.DoacaoNaoEncontradaException;
import com.adaiasmartins.doacaodesangue.Doacao.Repositories.RepositorioDeDoacoes;
import com.adaiasmartins.doacaodesangue.Doador.Exceptions.DoadorNaoEncontradoException;
import com.adaiasmartins.doacaodesangue.Doador.Repositories.RepositorioDeDoadores;
import org.springframework.stereotype.Service;

@Service
public class DoacaoService {

    private RepositorioDeDoadores repositorioDeDoadores;
    private RepositorioDeDoacoes repositorioDeDoacoes;

    public Doacao criarDoacao(CriarDoacaoDTO data) throws Exception {
        try {
            if (repositorioDeDoadores.findByCpf(data.cpfDoador()) == null) {
                throw new DoadorNaoEncontradoException("Doador não encontrado");
            }
            Doacao doacao = new Doacao(data);
            return repositorioDeDoacoes.save(doacao);
        } catch (Exception e) {
            throw new Exception("Erro ao criar doação");
        }
    }

    public Doacao buscarDoacao(Long id) throws Exception {
        try {
            if(repositorioDeDoacoes.findByID(id) == null){
                throw new DoacaoNaoEncontradaException("Doação não encontrada");
            }
            Doacao doacao = repositorioDeDoacoes.findByID(id);
            return doacao;
        } catch (Exception e) {
            throw new Exception("Erro ao buscar doação");
        }
    }

    public void deletarDoacao(Long id) throws Exception {
        try {
            if (repositorioDeDoacoes.findByID(id) == null) {
                throw new DoacaoNaoEncontradaException("Doação não encontrada");
            }
        } catch (Exception e) {
            throw new Exception("Erro ao deletar doação");
        }
    }
}
