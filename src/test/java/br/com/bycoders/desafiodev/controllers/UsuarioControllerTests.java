package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.forms.UsuarioForm;
import br.com.bycoders.desafiodev.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UsuarioControllerTests {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @Test
    public void criarUsuario(){
        when(usuarioService.salvar(any(Usuario.class))).thenReturn(new Usuario());

        ResponseEntity<Usuario> response = usuarioController.criarUsuario(getUsuarioForm(), UriComponentsBuilder.newInstance());

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getHeaders().containsKey("Location"));
    }

    private UsuarioForm getUsuarioForm(){
        return UsuarioForm.builder()
                .email("email@email.com")
                .nome("nome usuario")
                .senha("senha")
                .build();
    }

}
