package br.com.bycoders.desafiodev.responses;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class LojaResumoResponse {

    private String id;

    private String nome;

    private String dono;

    private BigDecimal totalizador;

    private List<OperacaoResumoResponse> operacoes;

}
