package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import br.com.bycoders.desafiodev.utils.MD5Util;
import org.apache.tomcat.util.security.MD5Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class CnabMapper{

    public static List<Operacao> mapper(InputStream inputStream) throws IOException {

        List<Operacao> operacaos = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

//        while(reader.ready()) {
//            operacaos.add(mapper(reader.readLine()));
//        }

        return operacaos;
    }

    public static Operacao mapperOperacao(String operacao){
        Operacao operacaoEntity = new Operacao();

        operacaoEntity.setTipo(getTipoTransacao(operacao));
        operacaoEntity.setData(getData(operacao));
        operacaoEntity.setValor(getValor(operacao));
        operacaoEntity.setCpfBeneficiario(getCpfBeneficiario(operacao));
        operacaoEntity.setCartao(getCartao(operacao));
        operacaoEntity.setHora(getHora(operacao));

        return operacaoEntity;
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
