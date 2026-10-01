package com.banca.cuentas.exception;

public class InvalidDataException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    
    private final String field;
    private final Object rejectedValue;
    
    public InvalidDataException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public InvalidDataException(String message, String field, Object rejectedValue) {
        super(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
    
    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public InvalidDataException(String field, String message) {
        super(String.format("El campo '%s' tiene datos inválidos: %s", field, message));
        this.field = field;
        this.rejectedValue = null;
    }
    
    public String getField() {
        return field;
    }
    
    public Object getRejectedValue() {
        return rejectedValue;
    }
}