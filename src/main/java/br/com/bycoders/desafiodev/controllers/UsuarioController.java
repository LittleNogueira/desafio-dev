package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.forms.UsuarioForm;
import br.com.bycoders.desafiodev.mappers.UsuarioMapper;
import br.com.bycoders.desafiodev.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> criarUsuario(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriComponentsBuilder){
        Usuario novoUsuario = usuarioService.salvar(UsuarioMapper.mapper(usuarioForm));
        URI uri = uriComponentsBuilder.path("/auth").build(novoUsuario);
        return ResponseEntity.created(uri).body(novoUsuario);
    }

}
