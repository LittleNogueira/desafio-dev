package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.repositories.UsuarioRespository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class UsuarioServiceTests {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRespository usuarioRespository;

    @Test
    public void salvar(){
        when(usuarioRespository.save(any(Usuario.class))).thenReturn(new Usuario());

        Usuario usuario = usuarioService.salvar(new Usuario());

        assertNotNull(usuario);
        verify(usuarioRespository, times(1)).save(any(Usuario.class));
    }

    @Test
    public void loadUserByUsernameComSucesso(){
        when(usuarioRespository.findByEmail(any(String.class))).thenReturn(Optional.of(new Usuario()));

        UserDetails userDetails = usuarioService.loadUserByUsername("email");

        assertNotNull(userDetails);
        verify(usuarioRespository, times(1)).findByEmail("email");
    }

    @Test
    public void loadUserByUsernameComExcecao(){
        when(usuarioRespository.findByEmail(any(String.class))).thenReturn(Optional.empty());

        UsernameNotFoundException thrown = assertThrows(UsernameNotFoundException.class, () -> {
            usuarioService.loadUserByUsername("email");
        });

        verify(usuarioRespository, times(1)).findByEmail("email");
        assertEquals("Bad credentials!", thrown.getMessage());
    }

}
