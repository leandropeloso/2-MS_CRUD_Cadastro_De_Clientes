package br.com.admclient.exception;

public class ClientConflictException extends RuntimeException {
    public ClientConflictException(String message) {
        super(message);
    }
}
