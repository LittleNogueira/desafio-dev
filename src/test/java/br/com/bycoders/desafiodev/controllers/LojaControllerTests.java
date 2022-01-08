package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.responses.LojaResumoResponse;
import br.com.bycoders.desafiodev.services.LojaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class LojaControllerTests {

    @InjectMocks
    private LojaController lojaController;

    @Mock
    private LojaService lojaService;

    @Test
    public void resumoGeral(){
        when(lojaService.buscarTodos()).thenReturn(new ArrayList<>());

        ResponseEntity<List<LojaResumoResponse>> response = lojaController.resumoGeral();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void resumoPorLoja(){
        when(lojaService.buscarPorId(any())).thenReturn(new Loja());

        ResponseEntity<LojaResumoResponse> response = lojaController.resumoPorLoja("id");

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
