package dev.wandesson.resistence.rest.controller;

import dev.wandesson.resistence.exception.RegraNegocioException;
import dev.wandesson.resistence.rest.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraNegociosException(RegraNegocioException ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }
}
