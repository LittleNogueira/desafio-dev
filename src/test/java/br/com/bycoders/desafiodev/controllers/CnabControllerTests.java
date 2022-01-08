package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.services.CnabService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CnabControllerTests {

    @InjectMocks
    private CnabController cnabController;

    @Mock
    private CnabService cnabService;

    @Test
    public void processarCnab() throws Exception {
        when(cnabService.salvarCnab(any())).thenReturn(new ArrayList<>());

        File file = new File("src/test/resources/CNAB.txt");
        FileInputStream input = new FileInputStream(file);
        MultipartFile cnab = new MockMultipartFile("cnab", input);

        ResponseEntity<List<Loja>> response = cnabController.processarCnab(cnab, UriComponentsBuilder.newInstance());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getHeaders().containsKey("Location"));
    }

}
