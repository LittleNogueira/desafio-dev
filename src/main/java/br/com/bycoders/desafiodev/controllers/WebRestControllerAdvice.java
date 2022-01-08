package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.dtos.Erro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public List<Erro> handler(MissingServletRequestPartException exceptions){
        List<Erro> errors = new ArrayList<>();
        errors.add(new Erro(exceptions.getMessage()));
        return errors;
    }
}
