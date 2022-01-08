package br.com.bycoders.desafiodev.entities;

import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    private TransacaoEnum tipo;

    private LocalDate data;

    private BigDecimal valor;

    private String cpfBeneficiario;

    private String cartao;

    private LocalTime hora;

}
