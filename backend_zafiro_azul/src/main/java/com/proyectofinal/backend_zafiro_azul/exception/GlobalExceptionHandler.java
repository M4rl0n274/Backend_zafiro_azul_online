package com.proyectofinal.backend_zafiro_azul.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        // Recorrer los errores de los campos y agregar los mensajes a un mapa
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);  // Devolver un 400 con los errores
    }

    @ExceptionHandler(CategoriaProductoNotFoundException.class)
    public ResponseEntity<?> handleCategoriaProductoNotFound(CategoriaProductoNotFoundException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("idCategoria", ex.getIdCategoria());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<?> handleNoDataFoundException(NoDataFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("entidad", ex.getEntityName());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityConflictException.class)
    public ResponseEntity<?> handleEntityConflictException(EntityConflictException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("entidad", ex.getEntityName());
        errorResponse.put("campo", ex.getFieldName());
        errorResponse.put("valor", ex.getFieldValue());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidArgumentException(InvalidArgumentException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("campo", ex.getFieldName());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DetallePedidoNotFoundException.class)
    public ResponseEntity<?> handleDetallePedidoNotFoundException(DetallePedidoNotFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("idDetallePedido", ex.getIdDetalle());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EstadoPedidoNotFoundException.class)
    public ResponseEntity<?> handleEstadoPedidoNotFoundException(EstadoPedidoNotFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Estado pedido no encontrado");
        errorResponse.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<?> handlePedidoNotFoundException(PedidoNotFoundException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("idPedido", ex.getIdPedido());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoChangesMadeException.class)
    public ResponseEntity<?> handleNoChangesMadeException(NoChangesMadeException ex){
        Map<String, Object> requestResponse = new HashMap<>();
        requestResponse.put("result", ex.getMessage());
        return new ResponseEntity<>(requestResponse, HttpStatus.OK);
    }

    @ExceptionHandler(MonetaryCalculationException.class)
    public ResponseEntity<?> handleMonetaryCalculationException(MonetaryCalculationException ex){
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Cálculo monetario fallido");
        errorResponse.put("mensaje", ex.getMessage());
        errorResponse.put("tipo de cálculo", ex.getTipoCalculo());
        errorResponse.put("entidad", ex.getEntidad());
        errorResponse.put("valor esperado", ex.getValorEsperado());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
