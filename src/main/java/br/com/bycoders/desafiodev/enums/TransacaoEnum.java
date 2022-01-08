package br.com.bycoders.desafiodev.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TransacaoEnum {
    DEBITO(1, "Débito", "Entrada"),
    BOLETO(2, "Boleto", "Saída"),
    FINANCIAMENTO(3, "Financiamento", "Saída"),
    CREDITO(4, "Crédito", "Entrada"),
    RECEBIMENTO_EMPRESTIMO(5, "Recebimento Empréstimo", "Entrada"),
    VENDAS(6, "Vendas", "Entrada"),
    RECEBIMENTO_TED(7, "Recebimento TED", "Entrada"),
    RECEBIMENTO_DOC(8, "Recebimento DOC", "Entrada"),
    ALGUEL(9, "Aluguel", "Saída");

    private Integer codigo;

    private String nome;

    private String natureza;

    public static TransacaoEnum findByCodigo(Integer codigo){
        return Arrays.stream(TransacaoEnum.values())
                .filter(t -> t.codigo.equals(codigo))
                .findFirst()
                .orElseThrow();
    }

    public Boolean isEntrada(){
        return this.natureza.equals("Entrada");
    }

    TransacaoEnum(Integer codigo, String nome, String natureza){
        this.codigo = codigo;
        this.nome = nome;
        this.natureza = natureza;
    }

}
