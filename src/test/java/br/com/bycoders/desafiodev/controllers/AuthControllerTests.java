package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.forms.LoginForm;
import br.com.bycoders.desafiodev.mappers.LoginMapper;
import br.com.bycoders.desafiodev.responses.TokenResponse;
import br.com.bycoders.desafiodev.services.TokenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AuthControllerTests {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenService tokenService;

    @Test
    public void login(){
        UsernamePasswordAuthenticationToken authReq = LoginMapper.mapper(getLoginForm());
        when(authenticationManager.authenticate(any())).thenReturn(authReq);
        when(tokenService.generateToken(any())).thenReturn("token-jwt");

        ResponseEntity<TokenResponse> response = authController.login(getLoginForm());

        assertNotNull(response.getBody());
        assertEquals("token-jwt", response.getBody().getToken());
        assertEquals("Bearer", response.getBody().getType());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private LoginForm getLoginForm(){
        return LoginForm.builder()
                .email("email@email.com")
                .senha("senha")
                .build();
    }
}
