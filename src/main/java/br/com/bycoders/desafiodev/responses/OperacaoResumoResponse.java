package br.com.bycoders.desafiodev.responses;

import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class OperacaoResumoResponse {

    private Long id;

    private TransacaoEnum tipo;

    private String natureza;

    private LocalDate data;

    private BigDecimal valor;

    private String cpfBeneficiario;

    private String cartao;

    private LocalTime hora;
}
