package br.com.admclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdmClientNotFoundException extends RuntimeException {
    public AdmClientNotFoundException(String cnpj) {
        super("Não encontrado cliente com este CNPJ: " + cnpj);
    }
}