package com.proyectofinal.backend_zafiro_azul.exception;


public class EntityConflictException extends RuntimeException{
    private String entityName;
    private String fieldName;
    private String fieldValue;
    public EntityConflictException(String entityName, String fieldName, String fieldValue) {
        super("Ya existe una " + entityName + " con " + fieldName + " '" + fieldValue + "'. Por favor elija otro " + fieldName + ".");
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
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

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
