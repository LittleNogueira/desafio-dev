package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${api.jwt.expiration}")
    private String expiration;

    @Value("${api.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication){

        Date dateNow = new Date();
        Date dateExpiration = new Date(dateNow.getTime() + Long.parseLong(expiration));

        Usuario user = (Usuario) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(user.getId().toString()) // Um indentificador
                .setIssuedAt(dateNow) // Date de criacao do token
                .setExpiration(dateExpiration) // Data de expiracao do token
                .signWith(SignatureAlgorithm.HS256, secret) // Hash para compactar token
                .compact(); // Retorna o token gerado
    }

    public boolean isValid(String token){
        try{
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Long getIdUserDetails(String token){
        return Long.parseLong(Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject());
    }
}
