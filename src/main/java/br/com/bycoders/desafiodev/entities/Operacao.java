package br.com.bycoders.desafiodev.entities;

import br.com.bycoders.desafiodev.enums.TransacaoEnum;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
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
