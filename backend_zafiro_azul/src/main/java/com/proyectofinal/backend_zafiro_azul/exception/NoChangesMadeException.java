package com.proyectofinal.backend_zafiro_azul.exception;

public class NoChangesMadeException extends RuntimeException {
    public NoChangesMadeException() {
        super("No se han realizado cambios.");
    }
}
