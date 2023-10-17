package br.com.admclient.exception;

public class ClientDataIntegrityException extends RuntimeException {
    public ClientDataIntegrityException(String message) {
        super(message);
    }
}
