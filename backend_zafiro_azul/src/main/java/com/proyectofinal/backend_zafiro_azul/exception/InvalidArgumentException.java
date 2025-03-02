package com.proyectofinal.backend_zafiro_azul.exception;



public class InvalidArgumentException extends RuntimeException {
    private String entityName;
    private String fieldName;
    public InvalidArgumentException(String entityName, String fieldName) {
        super(fieldName + " de " + entityName + " no puede estar vacío o nulo.");
        this.entityName = entityName;
        this.fieldName = fieldName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
