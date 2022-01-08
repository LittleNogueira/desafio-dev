package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.responses.LojaResumoResponse;
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
    public ResponseEntity<List<LojaResumoResponse>> resumoGeral(){
        return ResponseEntity.ok(ResumoMapper.mapperListLoja(lojaService.buscarTodos()));
    }

    @GetMapping("{id}/operacao")
    public ResponseEntity<LojaResumoResponse> resumoPorLoja(@PathVariable String id){
        return ResponseEntity.ok(ResumoMapper.mapper(lojaService.buscarPorId(id)));
    }

}
