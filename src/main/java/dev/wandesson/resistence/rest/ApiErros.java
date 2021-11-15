package dev.wandesson.resistence.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErros {

    @Getter
    private List<String> errors;

    public ApiErros(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }
}
