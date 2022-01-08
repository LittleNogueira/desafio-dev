package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import br.com.bycoders.desafiodev.utils.MD5Util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class CnabMapper{

    public static Operacao mapperOperacao(String operacao){
        return Operacao.builder()
                .tipo(getTipoTransacao(operacao))
                .data(getData(operacao))
                .valor(getValor(operacao))
                .cpfBeneficiario(getCpfBeneficiario(operacao))
                .cartao(getCartao(operacao))
                .hora(getHora(operacao))
                .build();
    }

    public static Loja mapperLoja(String operacao) throws Exception {
        Loja loja = new Loja();

        loja.setId(MD5Util.encode(getNomeLoja(operacao)));
        loja.setDono(getDonoLoja(operacao));
        loja.setNome(getNomeLoja(operacao));

        return loja;
    }


    private static TransacaoEnum getTipoTransacao(String operacao){
        return TransacaoEnum.findByCodigo(Integer.valueOf(operacao.substring(0,1)));
    }

    private static LocalDate getData(String operacao){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return LocalDate.parse(operacao.substring(1,9), formatter);
    }

    private static BigDecimal getValor(String operacao){
        BigDecimal valor = new BigDecimal(operacao.substring(9, 19));

        return valor.divide(new BigDecimal(100));
    }

    private static String getCpfBeneficiario(String operacao){
        return operacao.substring(19, 30);
    }

    private static String getCartao(String operacao){
        return operacao.substring(30, 42);
    }

    private static LocalTime getHora(String operacao){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");

        return LocalTime.parse(operacao.substring(42, 48), formatter);
    }

    private static String getDonoLoja(String operacao){
        return operacao.substring(48, 62).trim();
    }

    private static String getNomeLoja(String operacao){
        return operacao.substring(62, operacao.length()).trim();
    }
}
