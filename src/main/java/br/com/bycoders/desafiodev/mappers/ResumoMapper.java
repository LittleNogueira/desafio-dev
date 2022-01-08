package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.responses.LojaResumoResponse;
import br.com.bycoders.desafiodev.responses.OperacaoResumoResponse;
import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ResumoMapper {

    public static List<LojaResumoResponse> mapperListLoja(List<Loja> lojas){
        return lojas.stream().map(ResumoMapper::mapper).collect(Collectors.toList());
    }

    public static LojaResumoResponse mapper(Loja loja){
        return LojaResumoResponse.builder()
                .id(loja.getId())
                .nome(loja.getNome())
                .dono(loja.getDono())
                .totalizador(mapperTotalizador(loja.getOperacaos()))
                .operacoes(mapperListOperacoes(loja.getOperacaos()))
                .build();
    }

    public static List<OperacaoResumoResponse> mapperListOperacoes(List<Operacao> operacaos){
        return operacaos.stream().map(ResumoMapper::mapper).collect(Collectors.toList());
    }

    public static OperacaoResumoResponse mapper(Operacao operacao){
        return OperacaoResumoResponse.builder()
                .id(operacao.getId())
                .tipo(operacao.getTipo())
                .natureza(operacao.getTipo().getNatureza())
                .data(operacao.getData())
                .valor(operacao.getValor())
                .cpfBeneficiario(operacao.getCpfBeneficiario())
                .cartao(operacao.getCartao())
                .hora(operacao.getHora())
                .build();
    }

    private static BigDecimal mapperTotalizador(List<Operacao> operacoes){
        BigDecimal totalizador = BigDecimal.ZERO;

        for (Operacao operacao : operacoes){
            if(operacao.getTipo().isEntrada())
                totalizador = totalizador.add(operacao.getValor());
            else
                totalizador = totalizador.subtract(operacao.getValor());
        }

        return totalizador;
    }

}
