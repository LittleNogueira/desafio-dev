package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.forms.LoginForm;
import br.com.bycoders.desafiodev.mappers.LoginMapper;
import br.com.bycoders.desafiodev.responses.TokenResponse;
import br.com.bycoders.desafiodev.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Object> login(@RequestBody @Valid LoginForm loginForm){
        Authentication authentication = authenticationManager.authenticate(LoginMapper.mapper(loginForm));
        return ResponseEntity.ok(new TokenResponse(tokenService.generateToken(authentication),"Bearer"));
    }

}
