package br.com.bycoders.desafiodev.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class LojaResumo {

    private String id;

    private String nome;

    private String dono;

    private BigDecimal totalizador;

    private List<OperacaoResumo> operacoes;

}
