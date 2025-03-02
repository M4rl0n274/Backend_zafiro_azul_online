package com.proyectofinal.backend_zafiro_azul.exception;


public class CategoriaProductoNotFoundException extends RuntimeException {
    private Long idCategoria;  // Puedes incluir detalles adicionales si quieres

    public CategoriaProductoNotFoundException(Long idCategoria) {
        super("No se encontró la categoría de producto con ID: " + idCategoria);
        this.idCategoria = idCategoria;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
