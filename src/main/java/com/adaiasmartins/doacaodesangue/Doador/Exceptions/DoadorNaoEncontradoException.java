package com.adaiasmartins.doacaodesangue.Doador.Exceptions;

public class DoadorNaoEncontradoException extends Exception{
    public DoadorNaoEncontradoException(String msg){
        super("Doador não encontrado");
    }
}
