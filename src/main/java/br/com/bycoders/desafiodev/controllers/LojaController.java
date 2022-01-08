package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.dtos.LojaResumo;
import br.com.bycoders.desafiodev.mappers.ResumoMapper;
import br.com.bycoders.desafiodev.services.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService lojaService;

    @GetMapping("/operacao")
    public ResponseEntity<List<LojaResumo>> resumo(){
        return ResponseEntity.ok(ResumoMapper.mapperListLoja(lojaService.getAll()));
    }

    @GetMapping("{id}/operacao")
    public ResponseEntity<LojaResumo> resumo(@PathVariable String id){
        return ResponseEntity.ok(ResumoMapper.mapper(lojaService.getById(id)));
    }

}
