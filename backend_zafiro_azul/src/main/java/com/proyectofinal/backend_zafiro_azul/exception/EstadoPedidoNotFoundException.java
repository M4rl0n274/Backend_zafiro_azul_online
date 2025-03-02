package com.proyectofinal.backend_zafiro_azul.exception;



public class EstadoPedidoNotFoundException extends RuntimeException {
    private final Long idEstado;
    public EstadoPedidoNotFoundException(Long idEstado) {
        super("El detalle pedido con id " + idEstado + " no existe.");
        this.idEstado = idEstado;
      }

    public Long getIdEstado() {
        return idEstado;
    }
}

