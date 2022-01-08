package br.com.bycoders.desafiodev.forms;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class LoginForm {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

}
