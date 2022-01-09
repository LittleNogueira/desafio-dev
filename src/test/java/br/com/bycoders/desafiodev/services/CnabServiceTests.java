package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Loja;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CnabServiceTests {

    @InjectMocks
    private CnabService cnabService;

    @Mock
    private LojaService lojaService;

    @Test
    public void salvarCnab() throws Exception {
        File file = new File("src/test/resources/CNAB.txt");
        FileInputStream input = new FileInputStream(file);
        MultipartFile cnab = new MockMultipartFile("cnab", input);

        when(lojaService.salvar(any(Map.class))).thenReturn(new ArrayList<>());

        List<Loja> lojas = cnabService.salvarCnab(cnab.getInputStream());

        assertNotNull(lojas);
        verify(lojaService, times(1)).salvar(any(Map.class));
    }

}
