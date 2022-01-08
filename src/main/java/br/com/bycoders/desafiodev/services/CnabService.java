package br.com.bycoders.desafiodev.services;

import antlr.collections.impl.LList;
import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.mappers.CnabMapper;
import br.com.bycoders.desafiodev.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class CnabService {

    @Autowired
    private LojaService lojaService;

    public List<Loja> salvarCnab(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Map<Loja, List<Operacao>> hashMap = new HashMap<>();

        while(reader.ready()) {
            String operacao = reader.readLine();
            Loja loja = CnabMapper.mapperLoja(operacao);
            Operacao op = CnabMapper.mapperOperacao(operacao);

            if(hashMap.containsKey(loja)){
                List<Operacao> operacaos = new ArrayList<>(hashMap.get(loja));
                operacaos.add(op);
                hashMap.put(loja, operacaos);
            }else{
                hashMap.put(loja, Arrays.asList(op));
            }

        }

        return lojaService.save(hashMap);
    }

}
