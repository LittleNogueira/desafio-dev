package br.com.bycoders.desafiodev.services;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.repositories.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRespository usuarioRespository;

    public Usuario salvar(Usuario usuario){
        return usuarioRespository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usuarioRespository.findByEmail(s)
                .orElseThrow(() -> new UsernameNotFoundException("Bad credentials!"));
    }

}
