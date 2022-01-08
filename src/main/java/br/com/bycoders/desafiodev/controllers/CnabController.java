package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.services.CnabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/cnab")
public class CnabController {

    @Autowired
    private CnabService cnabService;

    @PostMapping
    public ResponseEntity<List<Loja>> getCnab(@Valid @NotNull @RequestParam("cnab") MultipartFile cnab) throws Exception {
        return ResponseEntity.ok(cnabService.salvarCnab(cnab.getInputStream()));
    }

}
