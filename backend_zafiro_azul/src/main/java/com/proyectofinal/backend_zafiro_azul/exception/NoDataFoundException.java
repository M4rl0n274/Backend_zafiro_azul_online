package com.proyectofinal.backend_zafiro_azul.exception;



public class NoDataFoundException extends RuntimeException {
    private String entityName;

    public NoDataFoundException(String entityName) {
        super("No se encontraron " + entityName);
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
