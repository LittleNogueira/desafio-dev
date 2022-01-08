package br.com.bycoders.desafiodev.configs.filter;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.repositories.UsuarioRespository;
import br.com.bycoders.desafiodev.services.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class TokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRespository usuarioRespository;

    public TokenFilter(TokenService tokenService,UsuarioRespository usuarioRespository){
        this.tokenService = tokenService;
        this.usuarioRespository = usuarioRespository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {
        String token = this.getToken(request);

        if(tokenService.isValid(token)){
            this.authenticatedToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticatedToken(String token){
        Long id = this.tokenService.getIdUserDetails(token);
        Usuario user = this.usuarioRespository.findById(id).orElse(null);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("Authorization");

        if(Objects.nonNull(token) && !token.isEmpty() && token.startsWith("Bearer ")){
            return token.substring(7,token.length());
        }

        return null;
    }
}
