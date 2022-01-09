package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class CnabMapperTest {

    @Test
    public void mapperLoja() throws Exception {
        String cnab = "5201903010000013200556418150633123****7687145607MARIA JOSEFINALOJA DO Ó - MATRIZ";

        Loja loja = CnabMapper.mapperLoja(cnab);

        assertEquals("68c3b26079686adbe2e7c4d123ce5955", loja.getId());
        assertEquals("LOJA DO Ó - MATRIZ", loja.getNome());
        assertEquals("MARIA JOSEFINA", loja.getDono());
    }

    @Test
    public void mapperOperacao(){
        String cnab = "5201903010000013200556418150633123****7687145607MARIA JOSEFINALOJA DO Ó - MATRIZ";

        Operacao operacao = CnabMapper.mapperOperacao(cnab);

        assertEquals(TransacaoEnum.RECEBIMENTO_EMPRESTIMO, operacao.getTipo());
        assertEquals(LocalDate.of(2019, 3, 1), operacao.getData());
        assertEquals(new BigDecimal("132"), operacao.getValor());
        assertEquals("55641815063", operacao.getCpfBeneficiario());
        assertEquals("3123****7687", operacao.getCartao());
        assertEquals(LocalTime.of(14, 56, 7), operacao.getHora());
    }

}
