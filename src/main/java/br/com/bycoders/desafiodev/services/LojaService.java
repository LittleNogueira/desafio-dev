package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.exceptions.NotFoundException;
import br.com.bycoders.desafiodev.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> save(Map<Loja, List<Operacao>> lojaMap){
        List<Loja> lojas = new ArrayList<>();

        for (Map.Entry<Loja, List<Operacao>> entry : lojaMap.entrySet()) {
            Loja key = entry.getKey();

            Optional<Loja> optional = lojaRepository.findById(key.getId());

            Loja loja = optional.orElse(key);
            loja.getOperacaos().addAll(entry.getValue());

            lojas.add(loja);
        }

        return save(lojas);
    }

    public List<Loja> save(List<Loja> lojas){
        return lojaRepository.saveAll(lojas);
    }

    public List<Loja> getAll(){
        return lojaRepository.findAll();
    }

    public Loja getById(String id){
        return lojaRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

}
