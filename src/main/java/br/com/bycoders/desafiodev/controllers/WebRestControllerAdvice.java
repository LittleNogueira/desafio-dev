package br.com.bycoders.desafiodev.controllers;

import br.com.bycoders.desafiodev.responses.ErroFormResponse;
import br.com.bycoders.desafiodev.responses.ErroResponse;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormResponse> handler(MethodArgumentNotValidException exceptions){
        List<ErroFormResponse> errors = new ArrayList<>();
        return exceptions.getBindingResult().getFieldErrors().stream().map(ErroFormResponse::new).collect(Collectors.toList());
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException.class)
    public List<ErroResponse> handler(MissingServletRequestPartException exceptions){
        List<ErroResponse> errors = new ArrayList<>();
        errors.add(new ErroResponse(exceptions.getMessage()));
        return errors;
    }

    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErroResponse conflict(DataIntegrityViolationException exception) {
        return new ErroResponse(exception.getCause().getCause().getMessage());
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ErroResponse databaseError() {
        return new ErroResponse("databaseError");
    }
}
