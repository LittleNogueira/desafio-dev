package br.com.bycoders.desafiodev.dtos;

import lombok.Getter;

@Getter
public class Erro {
    private String mensagem;

    public Erro(String mensagem){
        this.mensagem = mensagem;
    }
}
