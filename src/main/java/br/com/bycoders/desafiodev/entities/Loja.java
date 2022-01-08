package br.com.bycoders.desafiodev.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Loja {

    @Id
    private String id;

    private String nome;

    private String dono;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Operacao> operacaos;

    public List<Operacao> getOperacaos() {
        if(Objects.isNull(this.operacaos)){
            this.operacaos = new ArrayList<>();
        }

        return this.operacaos;
    }
}
