package br.com.bycoders.desafiodev.responses;

import lombok.Getter;

@Getter
public class ErroResponse {
    private String mensagem;

    public ErroResponse(String mensagem){
        this.mensagem = mensagem;
    }
}
