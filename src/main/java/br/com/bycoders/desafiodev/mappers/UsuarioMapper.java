package br.com.bycoders.desafiodev.mappers;

import br.com.bycoders.desafiodev.entities.Usuario;
import br.com.bycoders.desafiodev.forms.UsuarioForm;

public abstract class UsuarioMapper {

    public static Usuario mapper(UsuarioForm usuarioForm){
        return Usuario.builder()
                .email(usuarioForm.getEmail())
                .senha(usuarioForm.getSenha())
                .nome(usuarioForm.getNome())
                .build();
    }

}
