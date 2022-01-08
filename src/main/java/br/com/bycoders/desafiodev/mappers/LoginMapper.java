package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.forms.LoginForm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public abstract class LoginMapper {

    public static UsernamePasswordAuthenticationToken mapper(LoginForm loginForm){
        return new UsernamePasswordAuthenticationToken(loginForm.getEmail(),loginForm.getSenha());
    }

}
