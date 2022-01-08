package br.com.bycoders.desafiodev.responses;

import lombok.Data;
import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class ErroFormResponse {
    public String field;
    public String message;

    public ErroFormResponse(FieldError fieldError){
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }
}
