package br.com.bycoders.desafiodev.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TransacaoEnum {
    DEBITO(1, "Débito", "in"),
    BOLETO(2, "Boleto", "out"),
    FINANCIAMENTO(3, "Financiamento", "out"),
    CREDITO(4, "Crédito", "in"),
    RECEBIMENTO_EMPRESTIMO(5, "Recebimento Empréstimo", "in"),
    VENDAS(6, "Vendas", "in"),
    RECEBIMENTO_TED(7, "Recebimento TED", "in"),
    RECEBIMENTO_DOC(8, "Recebimento DOC", "in"),
    ALGUEL(9, "Aluguel", "out");

    private Integer codigo;

    private String nome;

    private String natureza;

    public static TransacaoEnum findByCodigo(Integer codigo){
        return Arrays.stream(TransacaoEnum.values())
                .filter(t -> t.codigo.equals(codigo))
                .findFirst()
                .orElseThrow();
    }

    TransacaoEnum(Integer codigo, String nome, String natureza){
        this.codigo = codigo;
        this.nome = nome;
        this.natureza = natureza;
    }

}
