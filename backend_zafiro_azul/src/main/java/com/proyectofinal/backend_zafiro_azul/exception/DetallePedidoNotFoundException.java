package com.proyectofinal.backend_zafiro_azul.exception;


public class DetallePedidoNotFoundException extends RuntimeException {
    private final Long idDetalle;
    public DetallePedidoNotFoundException(Long idDetalle) {
        super("El detalle pedido con id " + idDetalle + " no existe.");
        this.idDetalle = idDetalle;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }
}
