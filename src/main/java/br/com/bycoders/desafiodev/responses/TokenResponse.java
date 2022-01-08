package br.com.bycoders.desafiodev.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private String type;

}
