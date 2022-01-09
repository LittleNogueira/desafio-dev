package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Loja;
import br.com.bycoders.desafiodev.entities.Operacao;
import br.com.bycoders.desafiodev.exceptions.NotFoundException;
import br.com.bycoders.desafiodev.mappers.CnabMapper;
import br.com.bycoders.desafiodev.repositories.LojaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class LojaServiceTests {

    @InjectMocks
    private LojaService lojaService;

    @Mock
    private LojaRepository lojaRepository;

    @Test
    public void salvarMap() throws Exception {
        String cnab1 = "5201903010000013200556418150633123****7687145607MARIA JOSEFINALOJA DO Ó - MATRIZ";
        Loja loja = CnabMapper.mapperLoja(cnab1);
        Operacao operacao = CnabMapper.mapperOperacao(cnab1);

        Map<Loja, List<Operacao>> lojaListMap = new HashMap<>();
        lojaListMap.put(loja, Arrays.asList(operacao));

        when(lojaRepository.saveAll(any())).thenReturn(new ArrayList<>());

        List<Loja> lojas = lojaService.salvar(lojaListMap);

        assertNotNull(loja);
        verify(lojaRepository, times(1)).saveAll(any());
    }

    @Test
    public void salvarLista() {
        when(lojaRepository.saveAll(any(List.class))).thenReturn(new ArrayList<>());

        List<Loja> lojas = lojaService.salvar(new ArrayList<>());

        assertNotNull(lojas);
        verify(lojaRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void buscarTodos() {
        when(lojaRepository.findAll()).thenReturn(new ArrayList<>());

        List<Loja> lojas = lojaService.buscarTodos();

        assertNotNull(lojas);
        verify(lojaRepository, times(1)).findAll();
    }

    @Test
    public void buscarPorIdComSucesso() {
        when(lojaRepository.findById("id")).thenReturn(Optional.of(new Loja()));

        Loja loja = lojaService.buscarPorId("id");

        assertNotNull(loja);
        verify(lojaRepository, times(1)).findById("id");
    }

    @Test
    public void buscarPorIdComExcecaoNotFound() {
        when(lojaRepository.findById("id")).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            Loja loja = lojaService.buscarPorId("id");
        });

        verify(lojaRepository, times(1)).findById("id");
    }

}
